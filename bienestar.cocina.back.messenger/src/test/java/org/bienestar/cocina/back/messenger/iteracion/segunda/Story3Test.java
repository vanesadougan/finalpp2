package org.bienestar.cocina.back.messenger.iteracion.segunda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.bienestar.cocina.back.messenger.ConfigurationProvider;
import org.bienestar.cocina.back.messenger.MessageQueue;
import org.bienestar.cocina.back.messenger.MessageQueueChecker;
import org.bienestar.cocina.back.messenger.TextMessage;
import org.bienestar.cocina.back.messenger.breaker.CircuitBreaker;
import org.bienestar.cocina.back.messenger.messages.MessageDispatcher;
import org.bienestar.cocina.back.senders.MockSender;
import org.bienestar.cocina.back.senders.Sender;
import org.junit.Test;

public class Story3Test {

	private MessageQueue generateQueue() {
		return new MessageQueue();
	}
	
	private ConfigurationProvider getConfig() {
		return new ConfigurationProvider();
	}
	
	private Sender getSender() {
		return new MockSender();
	}
	
	private MessageDispatcher getDispatcher() {
		return new MessageDispatcher(new CircuitBreaker(10, 10), getSender());
	}
	
	private MessageQueueChecker generateChecker(MessageQueue queue) {
		return new MessageQueueChecker(queue, getDispatcher(), getConfig());
	}
	
	@Test
	public void envioExitoso() throws InterruptedException {
		MessageQueue queue = generateQueue();
		queue.add(new TextMessage("mensaje"));
		MessageQueueChecker checker = generateChecker(queue);
		checker.start();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void envioFallido() throws InterruptedException {
		MessageQueue queue = generateQueue();
		queue.add(new TextMessage("error"));
		MessageQueueChecker checker = generateChecker(queue);
		checker.start();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void envioEvento1Evento2() throws InterruptedException {
		MessageQueue queue = generateQueue();
		queue.add(new TextMessage("mensaje"));
		queue.add(new TextMessage("error"));
		MessageQueueChecker checker = generateChecker(queue);
		checker.start();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void verificarPendiente1() {
		MessageQueue queue = generateQueue();
		queue.add(new TextMessage("mensaje"));
		MessageQueueChecker checker = generateChecker(queue);
		//checker.start();
		assertEquals(1, queue.size());
	}

	@Test
	public void verificarPendiente5() {
		MessageQueue queue = generateQueue();
		queue.add(new TextMessage("mensaje"));
		queue.add(new TextMessage("mensaje"));
		queue.add(new TextMessage("mensaje"));
		queue.add(new TextMessage("mensaje"));
		queue.add(new TextMessage("mensaje"));
		MessageQueueChecker checker = generateChecker(queue);
		//checker.start();
		assertEquals(5, queue.size());
	}

	@Test
	public void verificarPendiente0() {
		MessageQueue queue = generateQueue();
		MessageQueueChecker checker = generateChecker(queue);
		//checker.start();
		assertEquals(0, queue.size());
	}

}

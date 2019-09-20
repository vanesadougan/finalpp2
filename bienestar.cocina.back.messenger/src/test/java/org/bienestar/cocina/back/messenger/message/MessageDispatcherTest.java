package org.bienestar.cocina.back.messenger.message;

import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.back.messenger.TextMessage;
import org.bienestar.cocina.back.messenger.breaker.CircuitBreaker;
import org.bienestar.cocina.back.messenger.messages.MessageDispatcher;
import org.bienestar.cocina.back.senders.Sender;
import org.bienestar.cocina.exceptions.SendingException;
import org.junit.Test;

public class MessageDispatcherTest {

	@Test()
	public void messageDispatchTest() throws Exception {
		CircuitBreaker cb = new CircuitBreaker(2, 1000);
		Sender sender = new Sender() {
			public void send(Message message) throws SendingException {
			}
		};
		MessageDispatcher dispatcher = new MessageDispatcher(cb, sender);
		dispatcher.dispatch(new TextMessage("message"));
	}
	
}

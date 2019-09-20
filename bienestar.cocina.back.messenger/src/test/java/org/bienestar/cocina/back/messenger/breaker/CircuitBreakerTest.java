package org.bienestar.cocina.back.messenger.breaker;

import static org.junit.Assert.assertEquals;

import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.back.messenger.TextMessage;
import org.bienestar.cocina.back.messenger.breaker.CircuitBreaker;
import org.bienestar.cocina.back.messenger.breaker.CircuitBreakerName;
import org.bienestar.cocina.back.messenger.breaker.CircuitBreakerRegistry;
import org.bienestar.cocina.back.messenger.messages.SendMessageCommand;
import org.bienestar.cocina.back.senders.Sender;
import org.bienestar.cocina.exceptions.SendingException;
import org.junit.Test;

public class CircuitBreakerTest {

	@Test(expected = SendingException.class)
	public void breakerOpen() throws Exception {
		CircuitBreaker breaker = new CircuitBreaker(new SendMessageCommand(new Sender() {
			public void send(Message message) throws SendingException {
				throw new SendingException("errorSender");
			}
		}, new TextMessage("mensaje")), 1, 5000);
		breaker.run();
	}

	@Test(expected = SendingException.class)
	public void breakerHalf() throws Exception {
		CircuitBreaker breaker = new CircuitBreaker(new SendMessageCommand(new Sender() {
			public void send(Message message) throws SendingException {
				throw new SendingException("errorSender");
			}
		}, new TextMessage("mensaje")), 1, 1);
		breaker.run();
		Thread.sleep(2);
		breaker.run();
	}

	@Test
	public void registerBreaker() {
		CircuitBreaker cb = new CircuitBreaker(1, 1);
		CircuitBreaker cb2 = new CircuitBreaker(1, 1);
		CircuitBreakerRegistry.getInstance().register(CircuitBreakerName.TEST_BREAKER.getNombre(), cb);
		CircuitBreakerRegistry.getInstance().register(CircuitBreakerName.TEST_BREAKER.getNombre(), cb2);
		CircuitBreaker cbRegistred = CircuitBreakerRegistry.getInstance()
				.getCircuitBreaker(CircuitBreakerName.TEST_BREAKER.getNombre());
		assertEquals(cb, cbRegistred);
	}

}

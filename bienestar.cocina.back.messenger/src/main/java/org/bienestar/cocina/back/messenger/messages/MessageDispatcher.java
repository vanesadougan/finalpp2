package org.bienestar.cocina.back.messenger.messages;

import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.back.messenger.breaker.CircuitBreaker;
import org.bienestar.cocina.back.senders.Sender;

public class MessageDispatcher<T extends Sender<Message<?>>> {

	private Message<?> message;
	private CircuitBreaker cb;
	private T sender;

	public MessageDispatcher(CircuitBreaker cb, T sender) {
		this.cb = cb;
		this.sender = sender;
	}

	public void dispatch(Message<?> message) throws Exception {
		SendMessageCommand sendCommand = new SendMessageCommand(sender, message);
		cb.setCommand(sendCommand);
		cb.run();
	}

}

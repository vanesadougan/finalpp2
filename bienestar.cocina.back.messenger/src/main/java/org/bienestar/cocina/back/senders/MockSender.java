package org.bienestar.cocina.back.senders;

import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.exceptions.SendingException;

public class MockSender implements Sender<Message<?>> {

	public void send(Message<?> message) throws SendingException {
		//if (message.toString() == "error") throw new SendingException("error");
		System.out.println("MENSAJE MOCK:" + message.toString());
	}
	
}

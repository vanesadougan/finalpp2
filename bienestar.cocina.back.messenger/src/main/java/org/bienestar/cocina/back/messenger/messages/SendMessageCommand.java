package org.bienestar.cocina.back.messenger.messages;

import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.back.messenger.breaker.CircuitBreakerCommand;
import org.bienestar.cocina.back.senders.Sender;

public class SendMessageCommand implements CircuitBreakerCommand {

	private Message message;
	private Sender sender;

	public SendMessageCommand(Sender sender, Message message) {
		this.message = message;
		this.sender = sender;
	}

	public void execute() throws Exception {
		sender.send(this.message);
	}

}

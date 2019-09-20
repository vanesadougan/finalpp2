package org.bienestar.cocina.back.messenger;

public class MessageObserver {

	//TODO: imeplementar la parte de observer para que funcione como corresponde
	
	private MessageQueue queue;

	public MessageObserver(MessageQueue queue) {
		this.queue = queue;
	}
	
	public void onMessageReceived(Message msg) {
		queue.add(msg);
	}
}

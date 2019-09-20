package org.bienestar.cocina.back.messenger;

import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageQueue extends ConcurrentLinkedQueue<Message> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MessageQueue instance;

	public static MessageQueue getInstance() {
		if (instance == null)
			instance = new MessageQueue();
		return instance;
	}

//	private MessageQueue() {
//
//	}

}

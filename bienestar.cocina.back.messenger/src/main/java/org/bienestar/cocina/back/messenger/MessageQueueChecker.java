package org.bienestar.cocina.back.messenger;

import org.bienestar.cocina.back.messenger.messages.MessageDispatcher;
import org.bienestar.cocina.back.senders.Sender;

public class MessageQueueChecker {

	private MessageQueue queue;
	private ConfigurationProvider config;
	private MessageDispatcher<Sender<Message<?>>> dispatcher;
	private boolean running;
	private Thread th;

	public MessageQueueChecker(MessageQueue queue, MessageDispatcher<Sender<Message<?>>> dispatcher,
			ConfigurationProvider config) {
		this.queue = queue;
		this.dispatcher = dispatcher;
		this.config = config;
		th = setUpWorker();
	}

	public void start() throws InterruptedException {
		running = true;
		th.start();
		Thread.sleep(1000);
	}

	private Thread setUpWorker() {
		 th = new Thread(new Runnable() {

			@Override
			public void run() {
				while (running) {
					while (!queue.isEmpty()) {
						try {
							dispatcher.dispatch(queue.poll());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(config.getMessageQueueCheckInterval() * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		return th;
	}

	public void stop() {
		running = false;
	}

}

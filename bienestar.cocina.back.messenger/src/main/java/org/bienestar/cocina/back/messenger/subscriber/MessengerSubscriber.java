package org.bienestar.cocina.back.messenger.subscriber;

import org.bienestar.cocina.pubsub.ConsumptionSubscriber;
import org.bienestar.cocina.pubsub.Subscriber;

public class MessengerSubscriber implements ConsumptionSubscriber{

	@Override
	public Subscriber getSubscriber() {
		return new Subscriber() {
			
			@Override
			public void onMessageReceived(Object message) {
				System.out.println(message);
				
			}
		};
	}

}

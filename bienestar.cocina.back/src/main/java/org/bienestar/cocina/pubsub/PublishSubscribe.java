package org.bienestar.cocina.pubsub;

import java.util.ArrayList;
import java.util.HashMap;

public class PublishSubscribe {

	private static PublishSubscribe instance;
	
	private PublishSubscribe() {}
	
	public static PublishSubscribe getInstance() {
		if (instance == null) {
			instance = new PublishSubscribe();
		}
		return instance;
	}
	
	private HashMap<String, ArrayList<Subscriber>> subscriptions = new HashMap<String, ArrayList<Subscriber>>();

	public void subscribe(String topic, Subscriber subscriber) {
		if (subscriptions.containsKey(topic)) {
			subscriptions.get(topic).add(subscriber);
		} else {
			ArrayList<Subscriber> subscriberList = new ArrayList<Subscriber>();
			subscriberList.add(subscriber);
			subscriptions.put(topic, subscriberList);
		}
	}

	public void publish(String topic, Object message) {
		if (!subscriptions.containsKey(topic))
			return;

		for (Subscriber subscriber : subscriptions.get(topic)) {
			subscriber.onMessageReceived(message);
		}
	}

}

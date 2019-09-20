package org.bienestar.cocina.pubsub;

public interface Subscriber {

	void onMessageReceived(Object message);

}

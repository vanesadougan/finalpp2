package org.bienestar.cocina.consumption;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.pubsub.Subscriber;

public class ConsumptionListener implements Subscriber {

	public void onMessageReceived(Object message) {
		Consumption consumption = (Consumption) message;
		
	}
	
}

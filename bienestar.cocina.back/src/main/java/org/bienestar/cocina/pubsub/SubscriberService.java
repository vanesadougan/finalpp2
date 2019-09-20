package org.bienestar.cocina.pubsub;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import org.bienestar.cocina.service.loader.IntegrationServiceLoader;

public class SubscriberService {

	private static SubscriberService service;
	private ServiceLoader<ConsumptionSubscriber> consumptionLoader;

	/**
	 * Creates a new instance of SubscriberService
	 * @throws IOException 
	 */
	private SubscriberService(String path) throws IOException {
		consumptionLoader = IntegrationServiceLoader.loadIntegrations(Paths.get(path), ConsumptionSubscriber.class);
	}

	/**
	 * Devuelve la instancia actual
	 * @throws IOException 
	 */
	public static synchronized SubscriberService getInstance(String path) throws IOException {
		if (service == null) {
			service = new SubscriberService(path);
		}
		return service;
	}

	/**
	 * Devuelve una nueva instancia
	 * @throws IOException 
	 */
	public static synchronized SubscriberService getNewInstance(String path) throws IOException {
		service = new SubscriberService(path);
		return service;
	}
	
	public ServiceLoader<ConsumptionSubscriber> getLoader(){
		return consumptionLoader;
	}
	
	public void subscribe() {
		try {
			Iterator<ConsumptionSubscriber> suscriberIterator = consumptionLoader.iterator();
			while (suscriberIterator.hasNext()) {
				ConsumptionSubscriber plugin = suscriberIterator.next();
				PublishSubscribe.getInstance().subscribe(SubscriptionTypes.CONSUMPTION.getType(), plugin.getSubscriber());
			}
		} catch (ServiceConfigurationError e) {
			e.printStackTrace();
		}
	}
}

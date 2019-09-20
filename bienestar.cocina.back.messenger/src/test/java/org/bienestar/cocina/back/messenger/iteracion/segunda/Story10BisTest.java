package org.bienestar.cocina.back.messenger.iteracion.segunda;

import java.io.IOException;

import org.bienestar.cocina.back.messenger.subscriber.MessengerSubscriber;
import org.bienestar.cocina.pubsub.SubscriberService;
import org.junit.Assert;
import org.junit.Test;

public class Story10BisTest {

	@Test
	public void pluginImpl() throws IOException{
		SubscriberService service = SubscriberService.getNewInstance("target");
		MessengerSubscriber impl = (MessengerSubscriber) service.getLoader().iterator().next();
		Assert.assertNotNull(impl);
	}
}

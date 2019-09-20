package org.bienestar.cocina.iteracion.segunda;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ServiceConfigurationError;

import org.bienestar.cocina.pubsub.ConsumptionSubscriber;
import org.bienestar.cocina.pubsub.SubscriberService;
import org.junit.Assert;
import org.junit.Test;

public class Story10Test {

	@Test
	public void getPluginMessengerSubscriber() throws IOException{
		SubscriberService service = SubscriberService.getNewInstance("src/test/resources/plugins/messenger");
		ConsumptionSubscriber impl = service.getLoader().iterator().next();
		Assert.assertNotNull(impl);
	}
	
	@Test
	public void emptyPlugin() throws IOException{
		SubscriberService service = SubscriberService.getNewInstance("src/test/resources/plugins/empty");
		Assert.assertFalse(service.getLoader().iterator().hasNext());
	}
	
	@Test(expected = ServiceConfigurationError.class)
	public void invalidPlugin() throws IOException{
		SubscriberService service = SubscriberService.getNewInstance("src/test/resources/plugins/invalid");
		service.getLoader().iterator().next();
	}
	
	@Test(expected = NoSuchFileException.class)
	public void notExist() throws IOException{
		SubscriberService.getNewInstance("src/test/resources/plugins/notexist");
	}
}

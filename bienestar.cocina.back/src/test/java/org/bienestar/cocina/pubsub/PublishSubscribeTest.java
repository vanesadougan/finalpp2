package org.bienestar.cocina.pubsub;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PublishSubscribeTest {

	@Before
	public void setUp() {
	}
	
	@Test
	public void subscriptionTest()  {
		PublishSubscribe.getInstance().subscribe("CONSUMO", new Subscriber() {
			public void onMessageReceived(Object message) {
				Assert.assertEquals("Azucar", ((Consumption) message).getIngredient().getName());
				Assert.assertEquals(new Double(1), ((Consumption) message).getQuantity());
			}
		});
		
		Consumption cons = new Consumption();
		Ingredient ingr = new Ingredient();
		ingr.setName("Azucar");
		cons.setIngredient(ingr);
		cons.setQuantity(new Double(1));
		PublishSubscribe.getInstance().publish("CONSUMO", cons);
	}
	
	@Test
	public void multipleSubscriptionTest()  {
		PublishSubscribe.getInstance().subscribe("CONSUMO", new Subscriber() {
			public void onMessageReceived(Object message) {
				Assert.assertEquals("Azucar", ((Consumption) message).getIngredient().getName());
				Assert.assertEquals(new Double(1), ((Consumption) message).getQuantity());
			}
		});
		PublishSubscribe.getInstance().subscribe("CONSUMO", new Subscriber() {
			public void onMessageReceived(Object message) {
				Assert.assertEquals("Azucar", ((Consumption) message).getIngredient().getName());
				Assert.assertEquals(new Double(1), ((Consumption) message).getQuantity());
			}
		});
		
		Consumption cons = new Consumption();
		Ingredient ingr = new Ingredient();
		ingr.setName("Azucar");
		cons.setIngredient(ingr);
		cons.setQuantity(new Double(1));
		PublishSubscribe.getInstance().publish("CONSUMO", cons);
	}
	
	@Test
	public void publishWithNoSubscribers() {
		PublishSubscribe.getInstance().publish("NOSUBSCRIBERS", null);
	}
	
}

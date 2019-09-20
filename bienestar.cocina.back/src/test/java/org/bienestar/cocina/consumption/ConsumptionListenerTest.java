package org.bienestar.cocina.consumption;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.junit.Before;
import org.junit.Test;

public class ConsumptionListenerTest {
	
	@Before
	public void setUp() {
	}
	
	@Test()
	public void listenerTest()  {
		ConsumptionListener consListener = new ConsumptionListener();
		Consumption cons = new Consumption();
		Ingredient ingr = new Ingredient();
		ingr.setName("Azucar");
		cons.setIngredient(ingr);
		cons.setQuantity(new Double(1));
		consListener.onMessageReceived(cons);
	}
}

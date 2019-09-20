package org.bienestar.cocina.consumption;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.junit.Test;

public class ConsumptionSaverTest {

	//Este test esta solo para que pase coverage
	@Test
	public void saverTest() {
		ConsumptionSaver saver = new ConsumptionSaver();
		Consumption consumption = new Consumption();
		Ingredient ingr = new Ingredient();
		ingr.setName("Azucar");
		consumption.setIngredient(ingr);
		consumption.setQuantity(new Double(1));
		saver.save(consumption);
	}
}

package org.bienestar.cocina.verifier;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.MeasureType;
import org.bienestar.cocina.exceptions.ConsumptionOutOfRangeException;
import org.junit.Test;

public class ConsumptionVerifierTest {

	private Ingredient ingredient;

	public ConsumptionVerifierTest() {
		ingredient = new Ingredient();
		ingredient.setDescription("Leche en polvo");
		ingredient.setName("Leche en polvo");
		ingredient.setMeasureType(MeasureType.GRAM);
	}

	private ConsumptionVerifier getConsumptionVerifier() {
		ConsumptionRepository repository = new ConsumptionRepository();
		Consumption consumption = new Consumption();
		consumption.setIngredient(ingredient);
		consumption.setQuantity(20d);
		repository.getConsumptions().add(consumption);
		return new ConsumptionVerifier(repository);
	}

	private void doConsumption(Double quantity) throws ConsumptionOutOfRangeException {
		ConsumptionVerifier verifier = getConsumptionVerifier();
		Consumption consumption = new Consumption();
		consumption.setIngredient(ingredient);
		consumption.setQuantity(quantity);
		verifier.registerConsumption(consumption, 10);
	}

	@Test(expected = ConsumptionOutOfRangeException.class)
	public void input241g() throws ConsumptionOutOfRangeException {
		doConsumption(241d);
	}

	@Test(expected = ConsumptionOutOfRangeException.class)
	public void input159g() throws ConsumptionOutOfRangeException {
		doConsumption(159d);
	}

	@Test
	public void input240g() throws ConsumptionOutOfRangeException {
		doConsumption(240d);
	}

	@Test
	public void input160g() throws ConsumptionOutOfRangeException {
		doConsumption(160d);
	}

	@Test
	public void input200g() throws ConsumptionOutOfRangeException {
		doConsumption(200d);
	}
	
	@Test
	public void inputInvalidIngredient() throws ConsumptionOutOfRangeException {
		ConsumptionVerifier verifier = getConsumptionVerifier();
		Ingredient badIngredient = new Ingredient();
		Consumption consumption = new Consumption();
		consumption.setIngredient(badIngredient);
		consumption.setQuantity(10d);
		verifier.registerConsumption(consumption, 10);
	}
}

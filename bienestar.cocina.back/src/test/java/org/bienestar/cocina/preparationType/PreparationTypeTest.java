package org.bienestar.cocina.preparationType;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PreparationTypeTest {
	@Test
	public void preparationTypeTest() {
		PreparationTypeRepository preparationTypeRepository = new PreparationTypeRepository();
		PreparationTypeInput preparationTypeInput = new PreparationTypeInput(
				preparationTypeRepository);
		preparationTypeInput.registerType("Infusion");
		assertTrue(preparationTypeInput.getPreparationType().contains(
				"Infusion"));

	}

}

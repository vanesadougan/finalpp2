package org.bienestar.cocina.preparation;

import static org.junit.Assert.assertTrue;

import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.bienestar.cocina.repository.RepositoryStore;
import org.junit.Test;

public class PreparationTest {

	@Test
	public void preparationTest() {
		PreparationRepository preparationRepository = new PreparationRepository();
		PreparationInput preparationInput = new PreparationInput(preparationRepository);
		preparationInput.registerPreparation("Leche Chocolatada");
		
		assertTrue(preparationInput.getPreparations().contains("Leche Chocolatada"));
	}
	
	@Test
	public void preparationTestInvalidInput() {
		PreparationRepository preparationRepository = new PreparationRepository();
		PreparationInput preparationInput = new PreparationInput(preparationRepository);
		
		assertTrue(preparationInput.getPreparationsByText("Test").isEmpty());
	}

	@Test
	public void preparationMock() {
		PreparationRegistryRepository repository = RepositoryStore.getInstance().getPreparationRegistryRepository();
		
	}
}

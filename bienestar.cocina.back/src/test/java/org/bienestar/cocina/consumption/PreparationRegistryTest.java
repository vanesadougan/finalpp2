package org.bienestar.cocina.consumption;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryInput;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.junit.Test;

public class PreparationRegistryTest {

	@Test
	public void preparationRegistryInputTest() {
		PreparationRegistryRepository repository = new PreparationRegistryRepository();
		PreparationRegistryInput input = new PreparationRegistryInput(repository);
		input.registerPreparationRegistry("01/01");
		List<PreparationRegistry> savedPreparationRegistries = input.getPreparationRegistries();
		LocalDate expected = LocalDate.of(LocalDate.now().getYear(), 1, 1);
		assertEquals(expected, savedPreparationRegistries.get(savedPreparationRegistries.size() - 1).getDate());
	}

}

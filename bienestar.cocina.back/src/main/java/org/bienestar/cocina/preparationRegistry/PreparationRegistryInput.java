package org.bienestar.cocina.preparationRegistry;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import org.bienestar.cocina.domain.PreparationRegistry;

public class PreparationRegistryInput {

	private PreparationRegistryRepository preparationRegistryRepository;

	public PreparationRegistryInput(PreparationRegistryRepository preparationRegistryRepository) {
		this.preparationRegistryRepository = preparationRegistryRepository;
	}

	public void registerPreparationRegistry(String date) {
		PreparationRegistry registry = new PreparationRegistry();
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM")
                .parseDefaulting(ChronoField.YEAR, Year.now().getValue())
                .toFormatter();
		registry.setDate(LocalDate.parse(date, formatter));
		preparationRegistryRepository.getPreparationRegistries().add(registry);
	}

	public List<PreparationRegistry> getPreparationRegistries() {
		return preparationRegistryRepository.getPreparationRegistries();
	}
}

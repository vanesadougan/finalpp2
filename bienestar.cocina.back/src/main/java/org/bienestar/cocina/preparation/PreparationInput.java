package org.bienestar.cocina.preparation;

import java.util.List;
import java.util.stream.Collectors;

import org.bienestar.cocina.domain.Preparation;

public class PreparationInput {

	private PreparationRepository preparationRepository;

	public PreparationInput(PreparationRepository preparationRepository) {
		this.preparationRepository = preparationRepository;
	}

	public void registerPreparation(String preparationInput) {
		Preparation preparation = new Preparation();
		preparation.setPreparation(preparationInput);
		preparationRepository.getPreparations().add(preparation);
	}
	
	public List<String> getPreparationsByText(String text) {
		return getPreparations().stream().filter(x -> x.indexOf(text) > 0).collect(Collectors.toList());
	}

	public List<String> getPreparations() {
		return preparationRepository.getPreparations().stream()
				.map(x -> x.getPreparation()).collect(Collectors.toList());
	}

}

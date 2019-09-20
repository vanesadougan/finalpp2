package org.bienestar.cocina.preparationType;

import java.util.List;
import java.util.stream.Collectors;

import org.bienestar.cocina.domain.PreparationType;

public class PreparationTypeInput {

	private PreparationTypeRepository preparationTypeRepository;

	public PreparationTypeInput(
			PreparationTypeRepository preparationTypeRepository) {
		this.preparationTypeRepository = preparationTypeRepository;
	}

	public void registerType(String type) {
		PreparationType preparationType = new PreparationType();
		preparationType.setType(type);
		preparationTypeRepository.getPreparationTypes().add(preparationType);
	}

	public List<String> getPreparationType() {
		return preparationTypeRepository.getPreparationTypes().stream()
				.map(x -> x.getType()).collect(Collectors.toList());
	}

}

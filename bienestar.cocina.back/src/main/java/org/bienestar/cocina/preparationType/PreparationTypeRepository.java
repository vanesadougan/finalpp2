package org.bienestar.cocina.preparationType;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.domain.PreparationType;

public class PreparationTypeRepository {
	private List<PreparationType> preparationTypes;

	public PreparationTypeRepository() {
		preparationTypes = new ArrayList<PreparationType>();
	}

	public List<PreparationType> getPreparationTypes() {
		return preparationTypes;
	}
}

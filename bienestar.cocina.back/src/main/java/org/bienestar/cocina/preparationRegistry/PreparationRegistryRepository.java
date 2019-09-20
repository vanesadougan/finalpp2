package org.bienestar.cocina.preparationRegistry;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.domain.PreparationRegistry;

public class PreparationRegistryRepository {

	private List<PreparationRegistry> preparationRegistries;
	
	public PreparationRegistryRepository() {
		preparationRegistries = new ArrayList<PreparationRegistry>();
	}

	public List<PreparationRegistry> getPreparationRegistries() {
		return preparationRegistries;
	}
}

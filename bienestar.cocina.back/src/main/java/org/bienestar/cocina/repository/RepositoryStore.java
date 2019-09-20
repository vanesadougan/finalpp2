package org.bienestar.cocina.repository;

import org.bienestar.cocina.preparation.PreparationRepository;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepositoryMock;
import org.bienestar.cocina.verifier.ConsumptionRepository;

public class RepositoryStore {
	
	private static RepositoryStore _instance;
	
	private RepositoryStore() {	}
	
	public static RepositoryStore getInstance() {
		if (_instance == null)
			_instance = new RepositoryStore();
		return _instance;
	}
	
	public PreparationRepository getPreparationRepository() {
		return new PreparationRepository();
	}

	public PreparationRegistryRepository getPreparationRegistryRepository() {
		return new PreparationRegistryRepositoryMock();
	}

	public ConsumptionRepository getConsumptionRepository() {
		return new ConsumptionRepository();
	}
	
}

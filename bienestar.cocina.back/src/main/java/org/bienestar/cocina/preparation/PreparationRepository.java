package org.bienestar.cocina.preparation;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.domain.Preparation;

public class PreparationRepository {
	private List<Preparation> preparations;

	public PreparationRepository() {
		preparations = new ArrayList<Preparation>();
	}

	public List<Preparation> getPreparations() {
		return preparations;
	}
}

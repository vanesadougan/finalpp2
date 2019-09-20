package org.bienestar.cocina.verifier;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.domain.Consumption;

public class ConsumptionRepository {

	private List<Consumption> consumptions;

	public ConsumptionRepository() {
		consumptions = new ArrayList<Consumption>();
	}

	public List<Consumption> getConsumptions() {
		return consumptions;
	}
}

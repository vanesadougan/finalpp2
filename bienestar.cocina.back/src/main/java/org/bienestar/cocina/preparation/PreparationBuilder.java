package org.bienestar.cocina.preparation;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Preparation;

public class PreparationBuilder {

	List<Consumption> consumptions;
	
	public PreparationBuilder() {
		consumptions = new ArrayList<>();
	}
	
	public void addConsumption(Consumption consumption){
		consumptions.add(consumption);
	}
	
	public Preparation build(){
		Preparation preparation = new Preparation();
		preparation.setConsumptions(consumptions);
		return preparation;
	}
	
}

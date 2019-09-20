package org.bienestar.cocina.domain;

import java.util.ArrayList;
import java.util.List;

public class Preparation {

	private String name;
	private List<Consumption> consumptions;
	private PreparationType type; 

	public Preparation() {
		consumptions = new ArrayList<>();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preparation other = (Preparation) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getPreparation() {
		return name;
	}

	public void setPreparation(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Consumption> getConsumptions() {
		return consumptions;
	}

	public void setConsumptions(List<Consumption> consumptions) {
		this.consumptions = consumptions;
	}

	public PreparationType getType() {
		return type;
	}

	public void setType(PreparationType type) {
		this.type = type;
	}
	
	public void addConsumption(Consumption consumption){
		this.consumptions.add(consumption);
	}
	
}

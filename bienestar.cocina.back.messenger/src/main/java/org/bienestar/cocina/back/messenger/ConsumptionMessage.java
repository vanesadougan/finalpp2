package org.bienestar.cocina.back.messenger;

import org.bienestar.cocina.domain.Consumption;

public class ConsumptionMessage implements Message<Consumption> {
	
	private Consumption consumption;

	public ConsumptionMessage(Consumption consumption) {
		this.consumption = consumption;
	}

	@Override
	public Consumption getMessage() {
		return this.consumption;
	}

}

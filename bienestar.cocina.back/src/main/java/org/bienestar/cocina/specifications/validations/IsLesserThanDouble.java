package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsLesserThanDouble extends AbstractSpecification<Double> {

	private Double value;
	
	public IsLesserThanDouble(Double value) {
		super();
		this.value = value;
	}

	public boolean isSatisfiedBy(Double t) {
		return value > t;
	}

}

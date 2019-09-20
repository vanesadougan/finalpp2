package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsGreaterThanDouble extends AbstractSpecification<Double> {

	private Double value;

	public IsGreaterThanDouble(Double value) {
		super();
		this.value = value;
	}

	public boolean isSatisfiedBy(Double t) {
		return value < t;
	}
}

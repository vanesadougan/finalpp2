package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsGreaterThan extends AbstractSpecification<Integer> {

	private Integer value;

	public IsGreaterThan(Integer value) {
		super();
		this.value = value;
	}

	public boolean isSatisfiedBy(Integer t) {
		return value < t;
	}
}
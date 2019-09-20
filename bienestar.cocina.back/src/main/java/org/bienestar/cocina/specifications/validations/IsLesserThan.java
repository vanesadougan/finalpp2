package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsLesserThan extends AbstractSpecification<Integer> {

	private Integer value;

	public IsLesserThan(Integer value) {
		super();
		this.value = value;
	}

	public boolean isSatisfiedBy(Integer t) {
		return value > t;
	}
}
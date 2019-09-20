package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsEquals extends AbstractSpecification<Integer> {

	private Integer value;
	
	public IsEquals(Integer value) {
		super();
		this.value = value;
	}

	public boolean isSatisfiedBy(Integer t) {
		return value.equals(t);
	}

}

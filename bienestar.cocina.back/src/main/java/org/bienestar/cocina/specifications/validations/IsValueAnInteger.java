package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsValueAnInteger extends AbstractSpecification<Double> {

	@Override
	public boolean isSatisfiedBy(Double value) {
		return value == Math.floor(value) && !Double.isInfinite(value);
	}

}

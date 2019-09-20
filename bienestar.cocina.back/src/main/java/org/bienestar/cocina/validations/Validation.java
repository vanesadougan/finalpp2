package org.bienestar.cocina.validations;

import org.bienestar.cocina.specifications.generic.Specification;

public class Validation<T> {

	private Specification<T> spec;
	
	private Exception ex;

	public Validation(Specification<T> spec, Exception ex) {
		this.spec = spec;
		this.ex = ex;
	}
	
	public void validate(T param) throws Exception {
		if (!spec.isSatisfiedBy(param)) {
			throw ex;
		}
	}
}

package org.bienestar.cocina.specifications.generic;

public abstract class AbstractSpecification<T> implements Specification<T> {

	public Specification<T> and(final Specification<T> specification) {
	    return new AndSpecification<T>(this, specification);
	  }
	
	public Specification<T> or(final Specification<T> specification) {
	    return new OrSpecification<T>(this, specification);
	  }
	
	public Specification<T> not(final Specification<T> specification) {
	    return new NotSpecification<T>(specification);
	  }
}

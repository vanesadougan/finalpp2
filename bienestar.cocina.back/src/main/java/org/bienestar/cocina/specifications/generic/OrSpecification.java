package org.bienestar.cocina.specifications.generic;

public class OrSpecification<T> extends AbstractSpecification<T> {

	private Specification<T> spec1;
	private Specification<T> spec2;

	public OrSpecification(Specification<T> spec1, Specification<T> spec2) {
		this.spec1 = spec1;
		this.spec2 = spec2;
	}

	public boolean isSatisfiedBy(T t) {
		return spec1.isSatisfiedBy(t) || spec2.isSatisfiedBy(t);
	}

}

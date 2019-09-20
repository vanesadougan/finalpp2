package org.bienestar.cocina.specifications.generic;

public class NotSpecification<T> extends AbstractSpecification<T> {

	private Specification<T> spec;

	public NotSpecification(Specification<T> spec) {
		this.spec = spec;
	}

	public boolean isSatisfiedBy(T t) {
		return !spec.isSatisfiedBy(t);
	}

}

package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsValidSeparator extends AbstractSpecification<String>{

	private String separator;
	
	public IsValidSeparator(String separator) {
		this.separator = separator;
	}
	
	public boolean isSatisfiedBy(String string) {
		return string.contains(separator);
	}

}

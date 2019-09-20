package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsFebruary extends AbstractSpecification<String>{

	private String separator;

	public IsFebruary(String separator) {
		this.separator = separator;
	}
	
	public boolean isSatisfiedBy(String string) {
		String[] split = string.split(separator);
		return Integer.valueOf(split[1]) == 2;
	}

}

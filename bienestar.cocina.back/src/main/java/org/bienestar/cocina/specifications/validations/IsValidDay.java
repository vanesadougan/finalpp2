package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsValidDay extends AbstractSpecification<String>{

	private String separator;
	private Integer daysOfMonth;

	public IsValidDay(String separator, Integer daysOfMonth) {
		this.separator = separator;
		this.daysOfMonth = daysOfMonth;
	}
	
	public boolean isSatisfiedBy(String string) {
		String[] split = string.split(separator);
		Integer dia = Integer.valueOf(split[0]);
		return dia <= daysOfMonth;
	}

}

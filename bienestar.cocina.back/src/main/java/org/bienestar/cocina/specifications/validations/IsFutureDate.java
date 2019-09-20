package org.bienestar.cocina.specifications.validations;

import java.time.LocalDate;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsFutureDate extends AbstractSpecification<String> {

	private String separator;

	public IsFutureDate(String separator) {
		this.separator = separator;
	}

	public boolean isSatisfiedBy(String input) {
		String[] splitted = input.split(separator);
		LocalDate nowDate = LocalDate.now();
		LocalDate inputDate = LocalDate.of(nowDate.getYear(), Integer.parseInt(splitted[1]), Integer.parseInt(splitted[0]));
		return inputDate.compareTo(nowDate) > 0;
	}

}

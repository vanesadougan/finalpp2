package org.bienestar.cocina.specifications.validations;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsLeapYear extends AbstractSpecification<String>{

	public boolean isSatisfiedBy(String string) {
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.isLeapYear(calendar.get(Calendar.YEAR));
	}

}

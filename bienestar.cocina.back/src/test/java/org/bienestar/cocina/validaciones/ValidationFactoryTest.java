package org.bienestar.cocina.validaciones;

import org.bienestar.cocina.exceptions.IncorrectDayOfMonthException;
import org.bienestar.cocina.exceptions.InvalidMonthException;
import org.bienestar.cocina.exceptions.InvalidSeparatorException;
import org.bienestar.cocina.exceptions.TooManySeparatorException;
import org.bienestar.cocina.validations.ValidationFactory;
import org.junit.Before;
import org.junit.Test;

public class ValidationFactoryTest {

	private ValidationFactory builder;
	
	@Before
	public void setUp() throws Exception {
		builder = new ValidationFactory();
	}
	
	@Test(expected = InvalidSeparatorException.class)
	public void incorrectSeparator() throws Exception {
		builder.isValidSeparator().validate("02&02");
	}
	
	@Test(expected = TooManySeparatorException.class)
	public void twoSeparators() throws Exception {
		builder.hasOnlyOneSeparator().validate("02/12/2010");
	}
	
	@Test(expected = InvalidMonthException.class)
	public void invalidMonth() throws Exception {
		builder.isValidMonth().validate("02/13");
	}
	
	@Test(expected = IncorrectDayOfMonthException.class)
	public void invalidDate() throws Exception {
		builder.isValidDayOfMonth().validate("30/02");
	}
	
	@Test
	public void correctSeparator() throws Exception {
		builder.isValidSeparator().validate("02/02");
	}
	
	@Test
	public void oneSeparator() throws Exception {
		builder.hasOnlyOneSeparator().validate("02/12");
	}
	
	@Test
	public void validMonth() throws Exception {
		builder.isValidMonth().validate("02/12");
	}
	
	@Test
	public void validDate() throws Exception {
		builder.isValidDayOfMonth().validate("31/03");
	}
}

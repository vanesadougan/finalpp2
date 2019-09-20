package org.bienestar.cocina.validations;

import org.bienestar.cocina.exceptions.IncorrectDayOfMonthException;
import org.bienestar.cocina.exceptions.InvalidMonthException;
import org.bienestar.cocina.exceptions.InvalidSeparatorException;
import org.bienestar.cocina.exceptions.TooManySeparatorException;
import org.bienestar.cocina.specifications.generic.NotSpecification;
import org.bienestar.cocina.specifications.generic.Specification;
import org.bienestar.cocina.specifications.validations.HasOneSeparator;
import org.bienestar.cocina.specifications.validations.Is30DaysMonth;
import org.bienestar.cocina.specifications.validations.Is31DaysMonth;
import org.bienestar.cocina.specifications.validations.IsFebruary;
import org.bienestar.cocina.specifications.validations.IsLeapYear;
import org.bienestar.cocina.specifications.validations.IsMonth;
import org.bienestar.cocina.specifications.validations.IsValidDay;
import org.bienestar.cocina.specifications.validations.IsValidSeparator;

public class ValidationFactory {

	public Validation<String> hasOnlyOneSeparator(){
		Specification<String> spec = new HasOneSeparator("/").or(new HasOneSeparator("-"));
		Exception ex = new TooManySeparatorException();
		return new Validation<String>(spec, ex);
	}
	
	public Validation<String> isValidSeparator(){
		Specification<String> spec = new IsValidSeparator("/").or(new IsValidSeparator("-"));
		Exception ex = new InvalidSeparatorException();
		return new Validation<String>(spec, ex);
	}
	
	public Validation<String> isValidMonth(){
		Specification<String> spec = new IsMonth("/");
		Exception ex = new InvalidMonthException();
		return new Validation<String>(spec, ex);
	}
	
	public Validation<String> isValidDayOfMonth(){
		Specification<String> is31daysMonthSpecification = new Is31DaysMonth("/").and(new IsValidDay("/", 31));
		Specification<String> is30daysMonthSpecification = new Is30DaysMonth("/").and(new IsValidDay("/", 30));
		Specification<String> notLeapYear = new NotSpecification<String>(new IsLeapYear());
		Specification<String> isFebruarySpecification = new IsFebruary("/").and(notLeapYear).and(new IsValidDay("/", 28));
		Specification<String> isFebruaryLeapYearSpecification = new IsFebruary("/").and(new IsLeapYear()).and(new IsValidDay("/", 29));
		Specification<String> isValidDaySpecification = is31daysMonthSpecification.or(is30daysMonthSpecification)
				.or(isFebruarySpecification).or(isFebruaryLeapYearSpecification);
		
		Exception ex = new IncorrectDayOfMonthException();
		return new Validation<String>(isValidDaySpecification, ex);
	}
}

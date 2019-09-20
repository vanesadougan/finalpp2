package org.bienestar.cocina.specifications.validations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.bienestar.cocina.specifications.generic.NotSpecification;
import org.bienestar.cocina.specifications.generic.Specification;
import org.junit.Test;

public class SpecificationsTest {

	@Test
	public void separatorCharRight() {
		Specification<String> spec = new IsValidSeparator("/");
		assertTrue(spec.isSatisfiedBy("02/04"));
	}

	@Test
	public void separatorCharWrong() {
		Specification<String> spec = new IsValidSeparator(")");
		assertFalse(spec.isSatisfiedBy("02/04"));
	}

	@Test
	public void oneSeparatorRight() {
		Specification<String> spec = new HasOneSeparator("/");
		assertTrue(spec.isSatisfiedBy("02/04"));
	}

	@Test
	public void oneSeparatorWrong() {
		Specification<String> spec = new HasOneSeparator("/");
		assertFalse(spec.isSatisfiedBy("02/04/2000"));
	}

	@Test
	public void validMonth() {
		Specification<String> spec = new IsMonth("/");
		assertTrue(spec.isSatisfiedBy("02/04"));
	}

	@Test
	public void invalidMonth() {
		Specification<String> spec = new IsMonth("/");
		assertFalse(spec.isSatisfiedBy("02/13"));
	}

	@Test
	public void isFebruary() {
		Specification<String> spec = new IsFebruary("/");
		assertTrue(spec.isSatisfiedBy("03/02"));
	}

	@Test
	public void is31DaysMonth() {
		Specification<String> spec = new Is31DaysMonth("/");
		assertTrue(spec.isSatisfiedBy("03/03"));
	}

	@Test
	public void is30DaysMonth() {
		Specification<String> spec = new Is30DaysMonth("/");
		assertTrue(spec.isSatisfiedBy("03/04"));
	}

	@Test
	public void lastFebruaryDay() {
		Specification<String> spec = new IsFebruary("/").and(new IsValidDay("/", 29));
		assertTrue(spec.isSatisfiedBy("29/02"));
	}

	@Test
	public void lastMarchDay() {
		Specification<String> spec = new Is31DaysMonth("/").and(new IsValidDay("/", 31));
		assertTrue(spec.isSatisfiedBy("31/03"));
	}

	@Test
	public void lastAprilDay() {
		Specification<String> spec = new Is30DaysMonth("/").and(new IsValidDay("/", 30));
		assertTrue(spec.isSatisfiedBy("30/04"));
	}

	@Test
	public void isNot30DaysMonth() {
		Specification<String> spec = new Is30DaysMonth("/").and(new IsValidDay("/", 30));
		assertFalse(spec.isSatisfiedBy("30/05"));
	}

	@Test
	public void isNotFebruary() {
		Specification<String> spec = new IsFebruary("/");
		assertFalse(spec.isSatisfiedBy("30/05"));
	}

	@Test
	public void invalidDays() {
		Specification<String> spec = new Is30DaysMonth("/").and(new IsValidDay("/", 30));
		assertFalse(spec.isSatisfiedBy("31/04"));
	}

	@Test
	public void isValidDay() {
		Specification<String> is31daysMonthSpecification = new Is31DaysMonth("/").and(new IsValidDay("/", 31));
		Specification<String> is30daysMonthSpecification = new Is30DaysMonth("/").and(new IsValidDay("/", 30));
		Specification<String> notLeapYear = new NotSpecification<String>(new IsLeapYear());
		Specification<String> isFebruarySpecification = new IsFebruary("/").and(notLeapYear)
				.and(new IsValidDay("/", 28));
		Specification<String> isFebruaryLeapYearSpecification = new IsFebruary("/").and(new IsLeapYear())
				.and(new IsValidDay("/", 29));
		Specification<String> isValidDaySpecification = is31daysMonthSpecification.or(is30daysMonthSpecification)
				.or(isFebruarySpecification).or(isFebruaryLeapYearSpecification);
		assertTrue(isValidDaySpecification.isSatisfiedBy("28/02"));
	}

	@Test
	public void isNotLeapYear() {
		Specification<String> leapYear = new IsLeapYear();
		assertTrue(leapYear.not(leapYear).isSatisfiedBy("30/04"));
	}

	@Test
	public void is31daysMonth() {
		Specification<String> is31DaysMonth = new Is31DaysMonth("/");
		assertFalse(is31DaysMonth.not(is31DaysMonth).isSatisfiedBy("30/05"));
	}

	@Test
	public void isFutureDate() {
		Specification<String> isFutureDate = new IsFutureDate("/");
		String inputString = String.format("%s/%s", LocalDate.now().getDayOfMonth() + 1,
				LocalDate.now().getMonth().getValue());
		assertTrue(isFutureDate.isSatisfiedBy(inputString));
	}

	@Test
	public void isPastDate() {
		Specification<String> isFutureDate = new IsFutureDate("/");
		String inputString = String.format("%s/%s", LocalDate.now().getDayOfMonth() - 1,
				LocalDate.now().getMonth().getValue());
		assertFalse(isFutureDate.isSatisfiedBy(inputString));
	}

	@Test
	public void isPresentDate() {
		Specification<String> isFutureDate = new IsFutureDate("/");
		String inputString = String.format("%s/%s", LocalDate.now().getDayOfMonth(),
				LocalDate.now().getMonth().getValue());
		assertFalse(isFutureDate.isSatisfiedBy(inputString));
	}

	@Test
	public void GreaterThan() {
		Specification<Integer> spec = new IsGreaterThan(2);
		assertTrue(spec.isSatisfiedBy(3));
	}

	@Test
	public void Equals() {
		Specification<Integer> spec = new IsEquals(1);
		assertTrue(spec.isSatisfiedBy(1));
	}
}

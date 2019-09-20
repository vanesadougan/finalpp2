package org.bienestar.cocina.interpreters;

public class DateContext {

	private String expression;
	private String separator;
	private String year;
	private String month;
	private String day;
	
	public DateContext(String expression) {
		this.expression = expression;
		separator = "/";
	}
	
	public String getExpression(){
		return expression;
	}
	
	public void setExpression(String expression){
		this.expression = expression;
	}
	
	public String getSeparator() {
		return separator;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getInterpretedDate(){
		return day + separator + month + separator + year;
	}
}

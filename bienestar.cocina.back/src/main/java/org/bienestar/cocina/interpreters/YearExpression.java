package org.bienestar.cocina.interpreters;

import java.util.Calendar;

public class YearExpression implements Expression{

	@Override
	public void interpret(DateContext contexto) {
		if(contexto.getYear() == null){
			Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
			contexto.setYear(currentYear.toString());
		}
	}

}

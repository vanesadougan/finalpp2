package org.bienestar.cocina.interpreters;

import org.apache.commons.lang3.StringUtils;

public class OrderTermExpression implements Expression{

	@Override
	public void interpret(DateContext contexto) {
		if(contexto.getDay() != null && !StringUtils.isNumeric(contexto.getDay()) && StringUtils.isNumeric(contexto.getMonth())){
			String newDay = contexto.getMonth();
			contexto.setMonth(contexto.getDay());
			contexto.setDay(newDay);
		}
		if(contexto.getYear() != null && !StringUtils.isNumeric(contexto.getYear()) && StringUtils.isNumeric(contexto.getMonth())){
			String newYear = contexto.getMonth();
			contexto.setMonth(contexto.getYear());
			contexto.setYear(newYear);
		}
	}

}

package org.bienestar.cocina.interpreters;

import org.apache.commons.lang3.StringUtils;

public class DayExpression implements Expression {

	@Override
	public void interpret(DateContext contexto) {
		String day = StringUtils.leftPad(contexto.getDay(), 2, "0");
		contexto.setDay(day);
	}

}

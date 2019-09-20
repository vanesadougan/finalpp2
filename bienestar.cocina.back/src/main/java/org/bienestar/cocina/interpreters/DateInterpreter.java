package org.bienestar.cocina.interpreters;

import java.util.List;

public class DateInterpreter {
	
	public String interpret(String date){
		DateContext context = new DateContext(date);
		List<Expression> expressions = InterpreterStructureFactory.dateStructure(context);
		for(Expression expression : expressions){
			expression.interpret(context);
		}
		return context.getInterpretedDate();
	}
}

package org.bienestar.cocina.interpreters;

import java.util.ArrayList;
import java.util.List;

public class InterpreterStructureFactory {

	public static List<Expression> dateStructure(DateContext context){
		List<Expression> expressions = new ArrayList<>();
		expressions.add(new ReplaceExpression(" "));
		expressions.add(new ReplaceExpression("-"));
		expressions.add(new ReplaceExpression(","));
		expressions.add(new DeleteTermExpression());
		expressions.add(new TermExpression());
		expressions.add(new OrderTermExpression());
		expressions.add(new DayExpression());
		expressions.add(new MonthExpression());
		expressions.add(new YearExpression());
		return expressions;
	}
}

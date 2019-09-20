package org.bienestar.cocina.interpreters;

public class TermExpression implements Expression{

	@Override
	public void interpret(DateContext contexto) {
		String[] splitted = contexto.getExpression().split(contexto.getSeparator());
		if(splitted.length > 0){
			contexto.setDay(splitted[0]);
		} 
		if (splitted.length > 1){
			contexto.setMonth(splitted[1]);
		} 
		if (splitted.length > 2){
			contexto.setYear(splitted[2]);
		}
	}

}

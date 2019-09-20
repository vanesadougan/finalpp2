package org.bienestar.cocina.interpreters;

import java.util.ArrayList;
import java.util.List;

public class DeleteTermExpression implements Expression{

	public DeleteTermExpression() {
		ignoredTerms = new ArrayList<>();
		ignoredTerms.add("de");
		ignoredTerms.add("");
	}
	
	@Override
	public void interpret(DateContext contexto) {
		String[] splitted = contexto.getExpression().split(contexto.getSeparator());
		StringBuilder builder = new StringBuilder();
		for(String term : splitted){
			if(!ignoredTerms.contains(term)){
				builder.append(term).append(contexto.getSeparator());
			}
		}
		contexto.setExpression(builder.substring(0, builder.length() - 1));
	}

	private List<String> ignoredTerms;
}

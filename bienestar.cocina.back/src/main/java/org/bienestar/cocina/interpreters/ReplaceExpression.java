package org.bienestar.cocina.interpreters;

public class ReplaceExpression implements Expression{

	private String replaceString;
	
	public ReplaceExpression(String replaceString) {
		this.replaceString = replaceString;
	}

	@Override
	public void interpret(DateContext contexto) {
		String modified = contexto.getExpression().replace(replaceString, "/");
		contexto.setExpression(modified);
	}

}

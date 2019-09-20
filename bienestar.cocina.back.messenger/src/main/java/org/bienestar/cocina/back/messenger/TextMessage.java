package org.bienestar.cocina.back.messenger;

public class TextMessage implements Message<String> {

	private String text;

	public TextMessage(String text) {
		super();
		this.text = text;
	}

	@Override
	public String getMessage() {
		return text;
	}
	
	@Override
	public String toString() {
		return getMessage();
	}

}

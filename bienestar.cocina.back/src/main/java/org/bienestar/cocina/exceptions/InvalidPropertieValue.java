package org.bienestar.cocina.exceptions;

public class InvalidPropertieValue extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;
	
	public InvalidPropertieValue(String key) {
		super("invalid.propertie.value");
		this.key = key;
	}
	
}

package org.bienestar.cocina.exceptions;

public class OpenCircuitException extends AbstractException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpenCircuitException() {
		super("ex.circuit.open");
	}
	
}

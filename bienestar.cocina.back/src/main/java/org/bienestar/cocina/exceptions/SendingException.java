package org.bienestar.cocina.exceptions;

public class SendingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SendingException() {
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Contructor con el Mensaje de Error
     *
     * @param message Mensaje de Error
     */
    public SendingException(String message) {
        super(message);
    }

}

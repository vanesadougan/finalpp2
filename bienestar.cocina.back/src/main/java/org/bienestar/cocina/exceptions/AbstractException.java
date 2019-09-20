package org.bienestar.cocina.exceptions;

import org.bienestar.cocina.internationalization.MessageResource;

public abstract class AbstractException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		MessageResource resource = MessageResource.getInstance();
		return resource.getMessage(super.getMessage());
	}
}

package com.agilelabs.exception;

public class UserAlreadyExistsException extends RuntimeException {

    
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String message) {
        super(message);
    }

    // You can add other constructors or customizations as needed

}

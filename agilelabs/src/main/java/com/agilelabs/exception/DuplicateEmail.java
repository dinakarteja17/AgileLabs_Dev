package com.agilelabs.exception;

public class DuplicateEmail extends Exception {
	 
	private static final long serialVersionUID = 1L;

	public DuplicateEmail(String message) {
	        super(message);
	    }
}

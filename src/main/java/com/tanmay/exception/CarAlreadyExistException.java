package com.tanmay.exception;

public class CarAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 210681283371381720L;

	public CarAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarAlreadyExistException(String message) {
		super(message);
	}

}

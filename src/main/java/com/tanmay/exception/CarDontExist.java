package com.tanmay.exception;

public class CarDontExist extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9096509021516446274L;

	public CarDontExist(String message) {
		super(message);
	}

}

package com.bank.exception;

public class InvalidOTPException extends RuntimeException{

	public InvalidOTPException(String message) {
		super(message);
	}
	
}

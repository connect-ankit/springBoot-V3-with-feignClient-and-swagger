package com.inn.assignment.third.exceptionHandler.customException;

public class ConnectionFailureException extends RuntimeException {
	public ConnectionFailureException(String message) {
		super(message);
	}
}

package com.inn.assignment.first.exception;

public class ConnectionFailureException extends RuntimeException {
	public ConnectionFailureException(String message) {
		super(message);
	}
}
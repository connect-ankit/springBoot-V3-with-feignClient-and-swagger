package com.inn.assignment.first.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestControllerAdvice
public class GlobalExceptionHandlerFirst {

	@Data
	@AllArgsConstructor
	private static class ErrorResponse {
		private int status;
		private String message;
		private LocalDateTime timestamp;
	}

	

	@ExceptionHandler(ConnectionFailureException.class)
	public ResponseEntity<Object> handleFException(ConnectionFailureException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<Object>(response, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	
	@ExceptionHandler(BuisnessException.class)
	public ResponseEntity<Object> handleFException(BuisnessException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

}

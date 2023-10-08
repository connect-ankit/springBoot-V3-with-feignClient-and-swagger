package com.inn.assignment.third.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inn.assignment.third.exceptionHandler.customException.ConnectionFailureException;
import com.inn.assignment.third.exceptionHandler.customException.JsonFormatException;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @Data
	    @AllArgsConstructor
	    private static class ErrorResponse {
	        private int status;
	        private String message;
	        private LocalDateTime timestamp;
	    }
    
    @ExceptionHandler(JsonFormatException.class)
    public ResponseEntity<Object> handleJsonFormatException(JsonFormatException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<Object>(response,  HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(ConnectionFailureException.class)
    public ResponseEntity<Object> handleFException(ConnectionFailureException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<Object>(response,  HttpStatus.SERVICE_UNAVAILABLE);
    }
    
    
    
  
}

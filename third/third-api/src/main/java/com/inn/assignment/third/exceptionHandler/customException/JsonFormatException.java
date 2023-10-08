package com.inn.assignment.third.exceptionHandler.customException;

public class JsonFormatException extends RuntimeException {
    public JsonFormatException(String message) {
        super(message);
    }
}

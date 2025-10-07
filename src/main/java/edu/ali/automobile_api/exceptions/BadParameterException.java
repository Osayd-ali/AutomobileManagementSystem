package edu.ali.automobile_api.exceptions;

public class BadParameterException extends RuntimeException {
    public BadParameterException(String message) {
        super(message);
    }
}

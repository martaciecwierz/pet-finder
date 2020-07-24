package com.example.petfinder.error.exception.validation;

public class PasswordIValidationException extends RuntimeException {
    public PasswordIValidationException(int length) {
        super("Password to short: " + length);
    }
}

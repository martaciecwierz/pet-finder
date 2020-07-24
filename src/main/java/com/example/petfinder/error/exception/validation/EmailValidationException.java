package com.example.petfinder.error.exception.validation;

public class EmailValidationException extends RuntimeException {
    public EmailValidationException(String email) {
        super("Email is not valid: " + email);
    }
}

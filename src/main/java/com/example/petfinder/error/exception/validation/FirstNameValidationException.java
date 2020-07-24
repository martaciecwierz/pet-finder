package com.example.petfinder.error.exception.validation;

public class FirstNameValidationException extends RuntimeException {
    public FirstNameValidationException(String firstName) {
        super("First name is too short: " + firstName);
    }
}

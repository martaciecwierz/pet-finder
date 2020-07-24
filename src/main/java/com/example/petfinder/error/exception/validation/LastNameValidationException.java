package com.example.petfinder.error.exception.validation;

public class LastNameValidationException extends RuntimeException {
    public LastNameValidationException(String lastName) {
        super("Last name is too short: " + lastName);
    }
}

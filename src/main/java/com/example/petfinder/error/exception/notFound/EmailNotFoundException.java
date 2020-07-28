package com.example.petfinder.error.exception.notFound;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(String email) {
        super("Email " + email + " not found");
    }
}

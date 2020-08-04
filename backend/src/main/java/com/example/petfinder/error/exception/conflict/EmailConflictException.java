package com.example.petfinder.error.exception.conflict;

public class EmailConflictException extends RuntimeException {
    public EmailConflictException(String email) {
        super("Email " + email + " exist");
    }
}

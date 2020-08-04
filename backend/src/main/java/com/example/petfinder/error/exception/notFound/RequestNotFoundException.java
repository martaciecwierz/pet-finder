package com.example.petfinder.error.exception.notFound;

public class RequestNotFoundException extends RuntimeException{

    public RequestNotFoundException(Long id) {
        super("Request id not found: " + id);
    }
}

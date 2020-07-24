package com.example.petfinder.error.exception.notFound;

public class RequestTypeNotFoundException extends RuntimeException{

    public RequestTypeNotFoundException(Long id) {
        super("Request type id not found: " + id);
    }
}

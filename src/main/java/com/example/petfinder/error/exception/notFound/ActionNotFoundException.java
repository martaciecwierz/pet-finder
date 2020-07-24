package com.example.petfinder.error.exception.notFound;

public class ActionNotFoundException extends RuntimeException{

    public ActionNotFoundException(Long id) {
        super("Action id not found: " + id);
    }
}

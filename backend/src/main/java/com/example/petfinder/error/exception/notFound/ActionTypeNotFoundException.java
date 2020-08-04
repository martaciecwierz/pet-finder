package com.example.petfinder.error.exception.notFound;

public class ActionTypeNotFoundException extends RuntimeException{

    public ActionTypeNotFoundException(Long id) {
        super("Action type id not found: " + id);
    }
}

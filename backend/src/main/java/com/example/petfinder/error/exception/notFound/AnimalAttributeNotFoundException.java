package com.example.petfinder.error.exception.notFound;

public class AnimalAttributeNotFoundException extends RuntimeException {
    public AnimalAttributeNotFoundException(Long id) {
        super("AnimalAttribute id not found: " + id);
    }
}

package com.example.petfinder.error.exception.notFound;

public class AnimalNotFoundException extends RuntimeException{

    public AnimalNotFoundException(Long id) {
        super("Animal id not found: " + id);
    }
}

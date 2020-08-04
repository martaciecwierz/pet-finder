package com.example.petfinder.error.exception.notFound;

public class AnimalTypeNotFoundException extends RuntimeException{

    public AnimalTypeNotFoundException(Long id) {
        super("Animal type id not found: " + id);
    }
}

package com.example.petfinder.error.exception.notFound;

public class AnimalImageNotFoundException extends RuntimeException{

    public AnimalImageNotFoundException(Long id) {
        super("Animal image id not found: " + id);
    }
}

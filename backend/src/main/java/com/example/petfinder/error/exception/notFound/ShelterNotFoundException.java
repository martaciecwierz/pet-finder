package com.example.petfinder.error.exception.notFound;

public class ShelterNotFoundException extends RuntimeException{

    public ShelterNotFoundException(Long id) {
        super("Shelter id not found: " + id);
    }
}

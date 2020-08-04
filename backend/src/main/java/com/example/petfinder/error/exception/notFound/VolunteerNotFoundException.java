package com.example.petfinder.error.exception.notFound;

public class VolunteerNotFoundException extends RuntimeException{

    public VolunteerNotFoundException(Long id) {
        super("Volunteer id not found: " + id);
    }
}

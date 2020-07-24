package com.example.petfinder.error.exception.notFound;

public class AdminNotFoundException extends RuntimeException{

    public AdminNotFoundException(Long id){
        super("Admin not found: " + id);
    }
}

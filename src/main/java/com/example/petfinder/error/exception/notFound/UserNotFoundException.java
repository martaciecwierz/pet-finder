package com.example.petfinder.error.exception.notFound;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("User not found: " + id);
    }
}

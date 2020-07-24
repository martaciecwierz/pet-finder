package com.example.petfinder.error.exception.conflict;

public class UsernameConflictException extends RuntimeException{

    public UsernameConflictException(String username){
        super("Username " + username + " exist");
    }
}

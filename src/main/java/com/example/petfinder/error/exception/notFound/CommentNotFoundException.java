package com.example.petfinder.error.exception.notFound;

public class CommentNotFoundException extends RuntimeException{

    public CommentNotFoundException(Long id) {
        super("Comment id not found: " + id);
    }
}

package com.example.petfinder.error.exception.notFound;

public class ArticleNotFoundException extends RuntimeException{

    public ArticleNotFoundException(Long id) {
        super("Article id not found: " + id);
    }
}

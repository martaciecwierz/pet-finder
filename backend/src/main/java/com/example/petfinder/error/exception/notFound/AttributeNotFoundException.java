package com.example.petfinder.error.exception.notFound;

public class AttributeNotFoundException extends RuntimeException {
    public AttributeNotFoundException(Long id) {
        super("Attribute id not found:  " + id);
    }
}

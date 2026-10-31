package com.example.ministry.error;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String resource, String identifier) {
        super(resource + " already exists: " + identifier);
    }
}

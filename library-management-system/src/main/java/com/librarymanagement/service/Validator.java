package com.librarymanagement.service;

public class Validator {
    public void validate(String value,String fieldName) throws InvalidBookException {
        if (value == null || value.isBlank()) {
            throw new InvalidBookException(fieldName + " is required!");
        }
    }
}

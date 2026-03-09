package com.librarymanagement.service;

public class InvalidBookException extends Exception {
    public InvalidBookException(String message){
        super(message);
    }
}

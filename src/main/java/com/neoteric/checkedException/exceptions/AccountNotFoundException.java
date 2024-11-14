package com.neoteric.checkedException.exceptions;

public class AccountNotFoundException extends RuntimeException{
    private String message;

    public AccountNotFoundException(String message) {
        super(message);

    }
}

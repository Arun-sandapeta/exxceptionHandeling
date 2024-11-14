package com.neoteric.checkedException.exceptions;

public class EnterAmountException extends RuntimeException{
    private String message;

    public EnterAmountException(String message) {
        this.message = message;
    }
}

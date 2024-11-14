package com.neoteric.checkedException.exceptions;

public class InsufficientBalanceException extends Exception{

    public String message;

    public InsufficientBalanceException(String message) {
        this.message = message;
    }


}

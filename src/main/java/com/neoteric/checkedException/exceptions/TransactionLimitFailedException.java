package com.neoteric.checkedException.exceptions;

public class TransactionLimitFailedException extends Exception{
    public String message;

    public TransactionLimitFailedException(String message) {
        super(message);

    }
}

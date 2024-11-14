package com.neoteric.checkedException;

import com.neoteric.checkedException.exceptions.InsufficientBalanceException;
import com.neoteric.checkedException.exceptions.TransactionLimitFailedException;

public interface RBIPayment {

    Payment transfer(String fromAccount, String toAccount, double amount) throws InsufficientBalanceException, TransactionLimitFailedException;
}

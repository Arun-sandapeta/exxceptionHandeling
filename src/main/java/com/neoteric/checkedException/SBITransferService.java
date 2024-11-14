package com.neoteric.checkedException;

import com.neoteric.checkedException.enums.PaymentStatusEnum;
import com.neoteric.checkedException.enums.TransferEnum;
import com.neoteric.checkedException.exceptions.EnterAmountException;
import com.neoteric.checkedException.exceptions.InsufficientBalanceException;
import com.neoteric.checkedException.exceptions.TransactionLimitFailedException;

import java.util.Date;
import java.util.UUID;

public abstract class SBITransferService implements RBIPayment {


    public Boolean balanceCheck(String accountNumber, Double amount) {
        Account accountBalance = SBIAccountDBService.accountMap.get(accountNumber);
        if (accountBalance != null && accountBalance.getBalance() > amount) {
            return true;
        } else {
            return false;
        }
    }

    protected abstract boolean transactionLimitCheck(Account account, Double amount);

    @Override
    public Payment transfer(String fromAccount, String toAccount, double amount) throws InsufficientBalanceException,TransactionLimitFailedException {
        Payment p = new Payment();

        if (amount <= 0) {
            throw new EnterAmountException("Amount must be greater than zero.");
        }
        // balance check
        if (this.balanceCheck(fromAccount, amount)) {
            Account account = SBIAccountDBService.accountMap.get(fromAccount);
            // transaction limit
            if (this.transactionLimitCheck(account, amount)) {

                p.setStatus(PaymentStatusEnum.SUCCESS.getLabel());
                p.setTransactionId(UUID.randomUUID().toString());
                p.setUter(UUID.randomUUID().toString());
                p.setTransactionDate(new Date());
                p.setAmount(amount);
                return p;

            }else {
                throw new TransactionLimitFailedException(TransferEnum.TRANSACTION_LIMIT_FAILED.getCode()+TransferEnum.TRANSACTION_LIMIT_FAILED.getLabel());
            }
        }else{
            throw new InsufficientBalanceException
                    (TransferEnum.INSUFFICIENT_BALANCE.getCode() + TransferEnum.INSUFFICIENT_BALANCE.getLabel());

        }

    }
}

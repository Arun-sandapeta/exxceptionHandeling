package com.neoteric.checkedException;

import com.neoteric.checkedException.enums.TransferEnum;
import com.neoteric.checkedException.exceptions.EnterAmountException;
import com.neoteric.checkedException.exceptions.InsufficientBalanceException;
import com.neoteric.checkedException.exceptions.TransactionLimitFailedException;

public class BankCustService {

    public static void main(String[] args) {


        RetailAccountServiceImpl retailAccountService = new RetailAccountServiceImpl();
        Account account = retailAccountService.createAccount("123465", "abcd1234");


        SBITransferService sbiTransferService = new RTGSSBITransferServiceImpl();


        try {
            sbiTransferService.transfer(account.getAccount(), "hdfc123", 5000000);
            System.out.println("Transfer successful");
        } catch (TransactionLimitFailedException e) {
            System.out.println(TransferEnum.TRANSACTION_LIMIT_FAILED.getCode() + TransferEnum.TRANSACTION_LIMIT_FAILED.getLabel());
        } catch (InsufficientBalanceException e) {
            System.out.println(TransferEnum.INSUFFICIENT_BALANCE.getCode() + "  " + TransferEnum.INSUFFICIENT_BALANCE.getLabel());
        } catch (EnterAmountException e) {
            System.out.println("EnterAmountException caught: " + e.getMessage());


        }
    }
}

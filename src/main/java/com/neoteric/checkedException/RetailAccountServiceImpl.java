package com.neoteric.checkedException;

import java.util.UUID;

public class RetailAccountServiceImpl implements RetailAccountService{
    @Override
    public Account createAccount(String aadhaar, String pan) {
        Account account = new Account();
        account.setAccount(UUID.randomUUID().toString());
        account.setBalance(1000000);
        account.setAadhaar(aadhaar);
        account.setPan(pan);
        SBIAccountDBService.accountMap.put(account.getAccount(),account);
        return account;
    }
}

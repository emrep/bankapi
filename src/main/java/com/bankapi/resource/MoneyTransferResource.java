package com.bankapi.resource;

import com.bankapi.service.AccountService;

import java.math.BigDecimal;

public class MoneyTransferResource {
    private AccountService accountService;

    public MoneyTransferResource(AccountService accountService) {
        this.accountService = accountService;
    }

    public String transferMoney(String fromIban, String toIban, BigDecimal amount) {
        accountService.transferMoney(fromIban, toIban, amount);
        return "The transaction is successful";
    }
}

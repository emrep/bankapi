package com.bankapi.service;

import com.bankapi.dao.AccountDao;
import com.bankapi.model.Account;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public boolean transferMoney(String fromIban, String toIban, BigDecimal amount) {
        Account fromAccount = accountDao.getAccount(fromIban);
        Account toAccount = accountDao.getAccount(toIban);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        return true;
    }
}

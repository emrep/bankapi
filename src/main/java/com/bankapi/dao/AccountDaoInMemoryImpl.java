package com.bankapi.dao;

import com.bankapi.exception.ResourceNotFoundException;
import com.bankapi.model.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoInMemoryImpl implements AccountDao {

    private List<Account> accounts = new ArrayList<>();

    public AccountDaoInMemoryImpl() {
        Account account1 = new Account("AL90208110080000001039531801", "Emre Pekkaya", new BigDecimal("123.56"));
        accounts.add(account1);
        Account account2 = new Account("FR7630066100410001057380116", "Osman Mert", new BigDecimal("1000.45"));
        accounts.add(account2);
        Account account3 = new Account("DE12500105170648489890", "Mete Tekin", BigDecimal.ZERO);
        accounts.add(account3);
    }

    @Override
    public Account getAccount(String iban) {
        return accounts.stream().filter(account -> account.getIban().equals(iban)).findFirst().orElseThrow(() -> new ResourceNotFoundException("The account can not be found"));
    }
}

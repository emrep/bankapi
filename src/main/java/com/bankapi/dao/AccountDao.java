package com.bankapi.dao;

import com.bankapi.model.Account;

public interface AccountDao {
    Account getAccount(String iban);
}

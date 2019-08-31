package com.bankapi.dao;

import com.bankapi.exception.ResourceNotFoundException;
import com.bankapi.model.Account;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountDaoInMemoryImplTest {

    @Test
    @DisplayName("get the account")
    public void testGetAccount() {
        AccountDao accountDao = new AccountDaoInMemoryImpl();
        Account account = accountDao.getAccount("DE12500105170648489890");
        assertEquals("Mete Tekin", account.getOwner());
    }

    @Test
    @DisplayName("try to get not existing account")
    public void testGetNotExistAccount() {
        AccountDao accountDao = new AccountDaoInMemoryImpl();
        assertThrows(ResourceNotFoundException.class, () -> accountDao.getAccount("XX12500105170648489890"));
    }
}
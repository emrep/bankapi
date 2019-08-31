package com.bankapi.service;

import com.bankapi.dao.AccountDao;
import com.bankapi.model.Account;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    @Mock
    AccountDao accountDao;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    @DisplayName("transfer money")
    public void testTransferMoney() {
        Account fromAccount = new Account("AL90208110080000001039531801", "Brian Black", new BigDecimal("250.00"));
        when(accountDao.getAccount("AL90208110080000001039531801")).thenReturn(fromAccount);
        Account toAccount = new Account("FR7630066100410001057380116", "Emre Pekkaya", new BigDecimal("10.25"));
        when(accountDao.getAccount("FR7630066100410001057380116")).thenReturn(toAccount);
        AccountService accountService = new AccountServiceImpl(accountDao);
        accountService.transferMoney("AL90208110080000001039531801", "FR7630066100410001057380116", new BigDecimal("10.25"));
        assertEquals(new BigDecimal("239.75"), fromAccount.getBalance());
        assertEquals(new BigDecimal("20.50"), toAccount.getBalance());
    }

}
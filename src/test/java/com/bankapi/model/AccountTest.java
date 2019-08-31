package com.bankapi.model;

import com.bankapi.exception.BalanceExceededException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    @DisplayName("deposit money to the account")
    public void testDeposit() {
        Account account = new Account("AL90208110080000001039531801", "Brian Black", new BigDecimal("250.00"));
        account.deposit(BigDecimal.TEN);
        assertEquals(new BigDecimal("260.00"), account.getBalance());
    }

    @Test
    @DisplayName("withdraw money from the account")
    public void testWithdraw() throws BalanceExceededException {
        Account account = new Account("FR7630066100410001057380116","Emre Pekkaya", new BigDecimal("50.00"));
        account.withdraw(new BigDecimal("23.04"));
        assertEquals(new BigDecimal("26.96"), account.getBalance());
    }

    @Test
    @DisplayName("try to withdraw money that is more than the balance of the account")
    public void testWithdrawMore() {
        Account account = new Account("FR7630066100410001057380116","Emre Pekkaya", new BigDecimal("50.00"));
        assertThrows(BalanceExceededException.class, () -> account.withdraw(new BigDecimal("80.45")));
    }
}

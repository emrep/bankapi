package com.bankapi.model;

import com.bankapi.exception.BalanceExceededException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Account {
    private String iban;
    private String owner;
    private BigDecimal balance;

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public synchronized void withdraw(BigDecimal amount) throws BalanceExceededException {
        if(balance.compareTo(amount) < 0) {
            throw new BalanceExceededException("The balance is exceeded");
        } else {
            balance = balance.subtract(amount);
        }
    }
}

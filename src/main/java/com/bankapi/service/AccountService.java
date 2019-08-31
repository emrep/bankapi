package com.bankapi.service;

import java.math.BigDecimal;

public interface AccountService {
    boolean transferMoney(String fromIban, String toIban, BigDecimal amount);
}

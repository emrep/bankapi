package com.bankapi.exception;

public class BalanceExceededException extends AbstractCustomRuntimeException {
    public BalanceExceededException(String message) {
        super(message);
    }
}

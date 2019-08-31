package com.bankapi.exception;

public abstract class AbstractCustomRuntimeException extends RuntimeException {
    AbstractCustomRuntimeException(String message) {
        super(message);
    }
}

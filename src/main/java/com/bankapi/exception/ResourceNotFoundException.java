package com.bankapi.exception;

public class ResourceNotFoundException extends AbstractCustomRuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
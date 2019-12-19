package com.example.kyfar.exceptions;

public class NullStringDataException extends RuntimeException {
    private static final String defaultMessage = "vse";

    public NullStringDataException() {
        super(defaultMessage);
    }

    public NullStringDataException(String message) {
        super(message);
    }
}

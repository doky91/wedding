package com.weddingplanner.exceptions;

import org.springframework.http.HttpStatus;

public class DataFailedException extends RuntimeException {
    private HttpStatus status;

    public DataFailedException(String message) {
        super(message);
    }

    public DataFailedException(String message, Throwable obj) {
        super(message, obj);
    }

    public DataFailedException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}

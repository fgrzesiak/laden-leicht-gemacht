package com.example.nutzung.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class NutzungAppException extends Exception {
    public HttpStatus status;

    public NutzungAppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ResponseEntity<Object> toResponseEntity() {
        return ResponseEntity.status(status).body(getMessage());
    }
}

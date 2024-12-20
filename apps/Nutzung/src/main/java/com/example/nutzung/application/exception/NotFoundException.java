package com.example.nutzung.application.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends NutzungAppException {

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

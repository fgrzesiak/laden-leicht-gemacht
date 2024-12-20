package com.example.nutzung.application.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends NutzungAppException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}

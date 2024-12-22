package com.example.infrastruktur.application.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends InfrastrukturAppException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}

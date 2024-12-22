package com.example.infrastruktur.application.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends InfrastrukturAppException {

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

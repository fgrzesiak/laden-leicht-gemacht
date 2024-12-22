package com.example.infrastruktur.adapter.primary.REST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.infrastruktur.application.exception.InfrastrukturAppException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ InfrastrukturAppException.class })
    public ResponseEntity<Object> handleRuntimeException(InfrastrukturAppException exception) {
        return exception.toResponseEntity();
    }
}
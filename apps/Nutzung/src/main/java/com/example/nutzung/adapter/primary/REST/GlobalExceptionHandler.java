package com.example.nutzung.adapter.primary.REST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.nutzung.application.exception.NutzungAppException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ NutzungAppException.class })
    public ResponseEntity<Object> handleRuntimeException(NutzungAppException exception) {
        return exception.toResponseEntity();
    }
}
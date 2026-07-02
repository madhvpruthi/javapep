package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return errors;
    }

    // Employee Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResource(ResourceNotFoundException ex) {

        return ex.getMessage();
    }

    // Illegal Argument
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegal(IllegalArgumentException ex) {

        return ex.getMessage();
    }

    // Any Other Exception
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {

        return ex.getMessage();
    }

}
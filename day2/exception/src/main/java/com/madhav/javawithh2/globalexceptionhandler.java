package com.madhav.javawithh2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalexceptionhandler {

    @ExceptionHandler(studentnotfoundexc.class)
    public ResponseEntity<String> handleStudentNotFound(studentnotfoundexc ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
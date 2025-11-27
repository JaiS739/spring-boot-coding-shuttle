package com.codingshuttle.restpractice.restPractice.advice;

import com.codingshuttle.restpractice.restPractice.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .myCustom("this is my custom to check the object creating using builder()")
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}

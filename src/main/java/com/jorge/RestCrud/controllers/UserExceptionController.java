package com.jorge.RestCrud.controllers;

import com.jorge.RestCrud.Exceptions.UserExistException;
import com.jorge.RestCrud.Exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserExistException.class)
    public ResponseEntity<Object> exception(UserExistException exception) {
        return new ResponseEntity<>("User already exists, imposible to create.", HttpStatus.FOUND);
    }
}

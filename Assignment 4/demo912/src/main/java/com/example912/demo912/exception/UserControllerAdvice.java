package com.example912.demo912.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {
      @ExceptionHandler(UserNotFoundException.class)
      public ResponseEntity<String> resourceNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<String>("User is invalid "+ex, HttpStatus.NOT_FOUND);
      }
}

package com.contaazul.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiError.of(e));
    }

    @ExceptionHandler(CoordinateOutsideFieldException.class)
    public ResponseEntity handleCoordinateOutsideFieldException(CoordinateOutsideFieldException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiError.of(e));
    }
}

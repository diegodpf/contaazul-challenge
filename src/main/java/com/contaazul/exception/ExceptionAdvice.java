package com.contaazul.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionAdvice {
    private static final String DEFAULT_ERROR_MESSAGE = "400 Bad Request";

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(DEFAULT_ERROR_MESSAGE);
    }

    @ExceptionHandler(CoordinateOutsideFieldException.class)
    public ResponseEntity handleCoordinateOutsideFieldException(CoordinateOutsideFieldException e) {
        return ResponseEntity.badRequest().body(DEFAULT_ERROR_MESSAGE);
    }
}

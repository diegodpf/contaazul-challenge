package com.contaazul.exception;

public class CoordinateOutsideFieldException extends RuntimeException {
    private final ExceptionDetails details;

    public CoordinateOutsideFieldException(ExceptionDetails details) {
        super("The robot is outside the field");
        this.details = details;
    }

    public ExceptionDetails getDetails() {
        return details;
    }
}

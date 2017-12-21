package com.contaazul.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

public class ApiError {
    private final String error;
    private final Map<String, Object> details;

    private ApiError(String error, Map<String, Object> details) {
        this.error = error;
        this.details = details;
    }

    public static ApiError of(ConstraintViolationException e) {
        Map<String, Object> details = new HashMap<>();

        for (ConstraintViolation<?> violation :  e.getConstraintViolations()) {
            details.put(violation.getInvalidValue().toString(), violation.getMessage());
        }

        return new ApiError("A validation error has been occurred.", details);
    }

    public static ApiError of(CoordinateOutsideFieldException e) {
        Map<String, Object> details = new HashMap<>();

        if (e.getDetails() != null) {
            details = e.getDetails().getDetailsMap();
        }

        return new ApiError(e.getMessage(), details);
    }

    public String getError() {
        return error;
    }

    public Map<String, Object> getDetails() {
        return details;
    }
}

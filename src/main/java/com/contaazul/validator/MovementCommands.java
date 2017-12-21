package com.contaazul.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MovementCommandValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@ReportAsSingleViolation
public @interface MovementCommands {
    String message() default "These commands are not valid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

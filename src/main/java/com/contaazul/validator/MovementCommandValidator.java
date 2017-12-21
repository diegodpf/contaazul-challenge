package com.contaazul.validator;

import com.contaazul.domain.mars.Movement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MovementCommandValidator implements ConstraintValidator<MovementCommands, String> {
    @Override
    public void initialize(MovementCommands constraintAnnotation) {
    }

    @Override
    public boolean isValid(String commands, ConstraintValidatorContext context) {
        for (Character command : commands.toCharArray()) {
            try {
                Movement.fromCommand(command);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }

        return true;
    }
}

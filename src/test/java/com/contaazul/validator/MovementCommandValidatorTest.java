package com.contaazul.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovementCommandValidatorTest {
    private MovementCommandValidator fixture;

    @Before
    public void setUp() {
        fixture = new MovementCommandValidator();
    }

    @Test
    public void isValidTest() {
        assertTrue(fixture.isValid("MMM", null));
    }

    @Test
    public void isValidWithInvalidCommandsTest() {
        assertFalse(fixture.isValid("MMAM", null));
    }
}

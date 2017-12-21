package com.contaazul.domain.mars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovementTest {
    @Test
    public void fromCommandTest() {
        assertEquals(Movement.RIGHT, Movement.fromCommand('R'));
        assertEquals(Movement.LEFT, Movement.fromCommand('L'));
        assertEquals(Movement.MOVE, Movement.fromCommand('M'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromCommandInvalidTest() {
        Movement.fromCommand('A');
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromCommandLowerCaseTest() {
        Movement.fromCommand('r');
    }
}

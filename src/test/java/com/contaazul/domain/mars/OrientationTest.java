package com.contaazul.domain.mars;

import org.junit.Test;

import static com.contaazul.domain.mars.Orientation.*;
import static org.junit.Assert.assertEquals;

public class OrientationTest {
    @Test
    public void rotateRightTest() {
        assertEquals(EAST, NORTH.rotateRight());

        assertEquals(SOUTH, EAST.rotateRight());

        assertEquals(WEST, SOUTH.rotateRight());

        assertEquals(NORTH, WEST.rotateRight());
    }

    @Test
    public void rotateLeftTest() {
        assertEquals(WEST, NORTH.rotateLeft());

        assertEquals(SOUTH, WEST.rotateLeft());

        assertEquals(EAST, SOUTH.rotateLeft());

        assertEquals(NORTH, EAST.rotateLeft());
    }
}

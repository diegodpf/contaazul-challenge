package com.contaazul.domain.mars;

import org.junit.Before;
import org.junit.Test;

import static com.contaazul.domain.mars.Orientation.NORTH;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FieldTest {
    private Field fixture;

    @Before
    public void setUp() {
        fixture = new Field(5, 5);
    }

    @Test
    public void isInsideTest() {
        Coordinate coordinate = new Coordinate(4, 4, NORTH);
        assertTrue(fixture.isInside(coordinate));
    }

    @Test
    public void isInsideHorizontalOutsideTest() {
        Coordinate coordinate = new Coordinate(5, 4, NORTH);
        assertFalse(fixture.isInside(coordinate));

        coordinate = new Coordinate(-1, 4, NORTH);
        assertFalse(fixture.isInside(coordinate));
    }

    @Test
    public void isInsideVerticalOutsideTest() {
        Coordinate coordinate = new Coordinate(4, 5, NORTH);
        assertFalse(fixture.isInside(coordinate));

        coordinate = new Coordinate(4, -1, NORTH);
        assertFalse(fixture.isInside(coordinate));
    }
}

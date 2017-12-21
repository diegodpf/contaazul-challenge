package com.contaazul.domain.mars;

import org.junit.Before;
import org.junit.Test;

import static com.contaazul.domain.mars.Orientation.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CoordinateTest {
    private Coordinate fixture;

    @Before
    public void setUp() {
        fixture = new Coordinate(0, 0, NORTH);
    }

    @Test
    public void rotateRightTest() {
        fixture.rotateRight();
        assertEquals(EAST, fixture.getOrientation());

        fixture.rotateRight();
        assertEquals(SOUTH, fixture.getOrientation());

        fixture.rotateRight();
        assertEquals(WEST, fixture.getOrientation());

        fixture.rotateRight();
        assertEquals(NORTH, fixture.getOrientation());
    }

    @Test
    public void rotateLeftTest() {
        fixture.rotateLeft();
        assertEquals(WEST, fixture.getOrientation());

        fixture.rotateLeft();
        assertEquals(SOUTH, fixture.getOrientation());

        fixture.rotateLeft();
        assertEquals(EAST, fixture.getOrientation());

        fixture.rotateLeft();
        assertEquals(NORTH, fixture.getOrientation());
    }

    @Test
    public void walkPositionsTest() {
        fixture.walkPositions(1);
        assertEquals((Integer) 1, fixture.getVerticalPosition());
        assertEquals((Integer) 0, fixture.getHorizontalPosition());

        fixture.rotateRight();
        fixture.walkPositions(2);
        assertEquals((Integer) 1, fixture.getVerticalPosition());
        assertEquals((Integer) 2, fixture.getHorizontalPosition());

        fixture.rotateRight();
        fixture.walkPositions(1);
        assertEquals((Integer) 0, fixture.getVerticalPosition());
        assertEquals((Integer) 2, fixture.getHorizontalPosition());

        fixture.rotateRight();
        fixture.walkPositions(2);
        assertEquals((Integer) 0, fixture.getVerticalPosition());
        assertEquals((Integer) 0, fixture.getHorizontalPosition());
    }

    @Test
    public void equalsTest() {
        Coordinate equalCoordinate = new Coordinate(0, 0, NORTH);

        assertEquals(equalCoordinate, fixture);
    }

    @Test
    public void equalsWithDifferentOrientationTest() {
        Coordinate equalCoordinate = new Coordinate(0, 0, SOUTH);

        assertNotEquals(equalCoordinate, fixture);
    }

    @Test
    public void equalsWithDifferentHorizontalPositionTest() {
        Coordinate equalCoordinate = new Coordinate(1, 0, NORTH);

        assertNotEquals(equalCoordinate, fixture);
    }

    @Test
    public void equalsWithDifferentVerticalPositionTest() {
        Coordinate equalCoordinate = new Coordinate(0, 1, NORTH);

        assertNotEquals(equalCoordinate, fixture);
    }
}

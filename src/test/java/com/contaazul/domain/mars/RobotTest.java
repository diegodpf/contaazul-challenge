package com.contaazul.domain.mars;

import org.junit.Before;
import org.junit.Test;

import static com.contaazul.domain.mars.Orientation.EAST;
import static com.contaazul.domain.mars.Orientation.NORTH;
import static com.contaazul.domain.mars.Orientation.SOUTH;
import static org.junit.Assert.assertEquals;

public class RobotTest {
    private Robot fixture;

    @Before
    public void setUp() {
        Coordinate initialCoordinate = new Coordinate(0, 0, NORTH);
        fixture = new Robot(initialCoordinate);
    }

    @Test
    public void moveTest() {
        fixture.move(Movement.MOVE);
        assertEquals((Integer) 1, fixture.getCoordinate().getVerticalPosition());
        assertEquals((Integer) 0, fixture.getCoordinate().getHorizontalPosition());
        assertEquals(NORTH, fixture.getCoordinate().getOrientation());

        fixture.move(Movement.RIGHT);
        fixture.move(Movement.MOVE);
        assertEquals((Integer) 1, fixture.getCoordinate().getVerticalPosition());
        assertEquals((Integer) 1, fixture.getCoordinate().getHorizontalPosition());
        assertEquals(EAST, fixture.getCoordinate().getOrientation());

        fixture.move(Movement.LEFT);
        fixture.move(Movement.LEFT);
        fixture.move(Movement.MOVE);
        fixture.move(Movement.LEFT);
        fixture.move(Movement.MOVE);
        assertEquals((Integer) 0, fixture.getCoordinate().getVerticalPosition());
        assertEquals((Integer) 0, fixture.getCoordinate().getHorizontalPosition());
        assertEquals(SOUTH, fixture.getCoordinate().getOrientation());
    }
}

package com.contaazul.domain.mars;

import com.contaazul.exception.CoordinateOutsideFieldException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.contaazul.domain.mars.Movement.MOVE;
import static com.contaazul.domain.mars.Movement.RIGHT;
import static com.contaazul.domain.mars.Orientation.*;
import static org.junit.Assert.assertEquals;

public class MarsServiceTest {
    private MarsService fixture;

    @Before
    public void setUp() {
        fixture = new MarsServiceImpl();
    }

    @Test
    public void moveRobotTest() {
        List<Movement> movements = Arrays.asList(MOVE, MOVE);
        Coordinate expected = new Coordinate(0, 2, NORTH);

        assertEquals(expected, fixture.moveRobot(movements));
    }

    @Test
    public void moveRobotRotatingTest() {
        List<Movement> movements = Arrays.asList(RIGHT, RIGHT, RIGHT);
        Coordinate expected = new Coordinate(0, 0, WEST);

        assertEquals(expected, fixture.moveRobot(movements));
    }

    @Test
    public void moveAndRotateRobotTest() {
        List<Movement> movements = Arrays.asList(MOVE, MOVE, RIGHT, MOVE, MOVE, RIGHT, MOVE, MOVE);
        Coordinate expected = new Coordinate(2, 0, SOUTH);

        assertEquals(expected, fixture.moveRobot(movements));
    }

    @Test(expected = CoordinateOutsideFieldException.class)
    public void moveRobotOutsideFieldTest() {
        List<Movement> movements = Arrays.asList(MOVE, MOVE, MOVE, MOVE, MOVE);

        fixture.moveRobot(movements);
    }
}

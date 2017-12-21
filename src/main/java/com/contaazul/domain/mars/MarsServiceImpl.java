package com.contaazul.domain.mars;

import com.contaazul.exception.CoordinateOutsideFieldException;
import com.contaazul.exception.ExceptionDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarsServiceImpl implements MarsService {
    @Override
    public Coordinate moveRobot(List<Movement> movements) {
        Field field = new Field(5, 5);
        Coordinate initialCoordinate = new Coordinate(0, 0, Orientation.NORTH);
        Robot robot = new Robot(initialCoordinate);

        movements.forEach(m -> {
            robot.move(m);

            if (!field.isInside(robot.getCoordinate())) {
                throw new CoordinateOutsideFieldException(
                        ExceptionDetails.of("coordinate", robot.getCoordinate().toString()));
            }
        });

        return robot.getCoordinate();
    }
}

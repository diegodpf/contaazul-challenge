package com.contaazul.domain.mars;

import java.util.List;

public interface MarsService {
    Coordinate moveRobot(List<Movement> movements);
}

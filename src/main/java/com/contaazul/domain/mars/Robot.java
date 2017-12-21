package com.contaazul.domain.mars;

public class Robot {
    private Coordinate coordinate;

    public Robot(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void move(Movement movement) {
        switch (movement) {
            case RIGHT:
                this.coordinate.rotateRight();
                break;
            case LEFT:
                this.coordinate.rotateLeft();
                break;
            case MOVE:
                this.coordinate.walkPositions(1);
        }
    }
}

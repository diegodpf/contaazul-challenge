package com.contaazul.domain.mars;

public class Coordinate {
    private Integer horizontalPosition;
    private Integer verticalPosition;
    private Orientation orientation;

    public Coordinate(Integer horizontalPosition, Integer verticalPosition, Orientation orientation) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.orientation = orientation;
    }

    public Integer getHorizontalPosition() {
        return horizontalPosition;
    }

    public Integer getVerticalPosition() {
        return verticalPosition;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void rotateRight() {
        this.orientation = this.orientation.rotateRight();
    }

    public void rotateLeft() {
        this.orientation = this.orientation.rotateLeft();
    }

    public void walkPositions(int positions) {
        switch (this.orientation) {
            case NORTH:
                this.verticalPosition += positions;
                break;
            case EAST:
                this.horizontalPosition += positions;
                break;
            case SOUTH:
                this.verticalPosition -= positions;
                break;
            case WEST:
                this.horizontalPosition -= positions;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (!horizontalPosition.equals(that.horizontalPosition)) return false;
        if (!verticalPosition.equals(that.verticalPosition)) return false;
        return orientation == that.orientation;
    }

    @Override
    public String toString() {
        return "(" + this.horizontalPosition + ", " + this.verticalPosition + ", " +
                this.orientation.getDisplayName() + ")";
    }
}

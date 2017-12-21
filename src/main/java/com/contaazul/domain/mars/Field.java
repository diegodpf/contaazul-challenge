package com.contaazul.domain.mars;

public class Field {
    private final int horizontalDimension;
    private final int verticalDimension;

    public Field(int horizontalDimension, int verticalDimension) {
        this.horizontalDimension = horizontalDimension;
        this.verticalDimension = verticalDimension;
    }

    public boolean isInside(Coordinate coordinate) {
        return coordinate.getHorizontalPosition() >= 0 &&
                coordinate.getHorizontalPosition() < this.horizontalDimension &&
                coordinate.getVerticalPosition() >= 0 &&
                coordinate.getVerticalPosition() < this.verticalDimension;
    }
}

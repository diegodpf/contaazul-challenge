package com.contaazul.domain.mars;

import java.util.ArrayList;
import java.util.List;

public enum Orientation {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private static final List<Orientation> clockwise;

    static {
        clockwise = new ArrayList<>();
        clockwise.add(NORTH);
        clockwise.add(EAST);
        clockwise.add(SOUTH);
        clockwise.add(WEST);
    }

    private final String displayName;

    Orientation(String displayName) {
        this.displayName = displayName;
    }

    public Orientation rotateRight() {
        int index = clockwise.indexOf(this) + 1;

        if (index == clockwise.size()) {
            index = 0;
        }

        return clockwise.get(index);
    }

    public Orientation rotateLeft() {
        int index = clockwise.indexOf(this) - 1;

        if (index == -1) {
            index = clockwise.size() + index;
        }

        return clockwise.get(index);
    }

    public String getDisplayName() {
        return displayName;
    }
}

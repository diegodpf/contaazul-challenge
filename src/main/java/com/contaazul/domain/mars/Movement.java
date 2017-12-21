package com.contaazul.domain.mars;

import java.util.stream.Stream;

public enum Movement {
    RIGHT('R'),
    LEFT('L'),
    MOVE('M');

    private final Character command;

    Movement(Character command) {
        this.command = command;
    }

    public static Movement fromCommand(Character command) {
        return Stream.of(Movement.values())
                .filter(m -> m.command.equals(command))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}

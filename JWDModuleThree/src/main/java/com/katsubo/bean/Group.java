package com.katsubo.bean;

import java.util.Optional;
import java.util.stream.Stream;

public enum Group {
    MULTIMEDIA("multimedia"),
    IO_DEVICES("io_devices"),
    POWER_SUPPLY("power_supply"),
    MEMORY("memory");

    private final String type;

    Group(String type){
        this.type = type;
    }

    public static Optional<Group> of(String type) {
        return Stream.of(Group.values())
                .filter(e -> e.type.equalsIgnoreCase(type))
                .findFirst();
    }
}

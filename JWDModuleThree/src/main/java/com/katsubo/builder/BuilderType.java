package com.katsubo.builder;

import java.util.Optional;
import java.util.stream.Stream;

public enum BuilderType {
    SAX("sax"),
    StAX("stax"),
    DOM("dom");

    private final String type;

    BuilderType(String type){
        this.type = type;
    }

    public static Optional<BuilderType> of(String type) {
        return Stream.of(BuilderType.values())
                .filter(e -> e.type.equalsIgnoreCase(type))
                .findFirst();
    }
}

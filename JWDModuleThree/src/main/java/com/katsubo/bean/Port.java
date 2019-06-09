package com.katsubo.bean;

import java.util.Optional;
import java.util.stream.Stream;

public enum Port {
    COM("com"),
    USB("usb"),
    JACK("jack"),
    ETHERNET("ethernet"),
    HDMI("hdmi"),
    PCI("pci");

    private final String type;

    Port(String type){
        this.type = type;
    }

    public static Optional<Port> of(String type) {
        return Stream.of(Port.values())
                .filter(e -> e.type.equalsIgnoreCase(type))
                .findFirst();
    }
}

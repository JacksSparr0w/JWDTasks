package com.katsubo.bean;

import com.katsubo.exception.EnumException;

public enum Material {
    GLASS,
    METAL,
    PLASTIC,
    RUBBER,
    WOOD;

    public static Material getMaterial(String string) throws EnumException {

        switch (string.toUpperCase()){
            case "GLASS":
                return GLASS;
            case "METAL":
                return METAL;
            case "PLASTIC":
                return PLASTIC;
            case "RUBBER":
                return RUBBER;
            case "WOOD":
                return WOOD;
            default:
                throw new EnumException("Invalid material of toy");
        }
    }
}

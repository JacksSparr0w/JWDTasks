package com.katsubo.bean;

import com.katsubo.exception.EnumException;

public enum Type {
    LITTLE_CAR,
    CAR,
    BIG_CAR,
    BALL,
    DOLL;

    public static Type getType(String string) throws EnumException{

        switch (string.toUpperCase()){
            case "LITTLE_CAR":
                return LITTLE_CAR;
            case "CAR":
                return CAR;
            case "BIG_CAR":
                return BIG_CAR;
            case "BALL":
                return BALL;
            case "DOLL":
                return DOLL;
            default:
                throw new EnumException("Invalid type of toy");
        }
    }
}

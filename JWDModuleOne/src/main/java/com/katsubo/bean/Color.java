package com.katsubo.bean;

import com.katsubo.exception.EnumException;

public enum Color {
    YELLOW,
    PINK,
    RED,
    BLUE,
    GREEN;

    public static Color getColor(String string) throws EnumException {

        switch (string.toUpperCase()){
            case "YELLOW":
                return YELLOW;
            case "PINK":
                return PINK;
            case "RED":
                return RED;
            case "BLUE":
                return BLUE;
            case "GREEN":
                return GREEN;
            default:
                throw new EnumException("Invalid color of toy");
        }
    }
}

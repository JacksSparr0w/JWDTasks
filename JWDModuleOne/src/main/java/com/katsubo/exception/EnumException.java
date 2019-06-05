package com.katsubo.exception;

public class EnumException extends Exception{
    public EnumException(){
        super();
    }

    public EnumException(String message, Throwable exception) {
        super(message, exception);
    }

    public EnumException(String message) {
        super(message);
    }

    public EnumException(Throwable exception) {
        super(exception);
    }
}

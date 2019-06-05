package com.katsubo.exception;

public class ParserException extends Exception {
    public ParserException(){
        super();
    }

    public ParserException(String message, Throwable exception) {
        super(message, exception);
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(Throwable exception) {
        super(exception);
    }
}

package com.katsubo.exception;

public class ReaderException extends Exception {
    public ReaderException(){
        super();
    }

    public ReaderException(String message, Throwable exception) {
        super(message, exception);
    }

    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(Throwable exception) {
        super(exception);
    }
}

package com.katsubo.exception;

public class SaverException extends Exception {
    public SaverException(){
        super();
    }

    public SaverException(String message, Throwable exception) {
        super(message, exception);
    }

    public SaverException(String message) {
        super(message);
    }

    public SaverException(Throwable exception) {
        super(exception);
    }
}

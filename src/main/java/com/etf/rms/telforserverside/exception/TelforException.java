package com.etf.rms.telforserverside.exception;

public class TelforException extends Exception {

    public TelforException(String message) {
        super(message);
    }

    public TelforException(String message, Throwable cause) {
        super(message, cause);
    }

}

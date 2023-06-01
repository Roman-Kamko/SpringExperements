package com.kamko.experements.itemapp.exceptions;

public class IllegalParametersException extends Exception {
    public IllegalParametersException() {
    }

    public IllegalParametersException(String message) {
        super(message);
    }

    public IllegalParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalParametersException(Throwable cause) {
        super(cause);
    }

    public IllegalParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

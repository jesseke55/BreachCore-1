package net.breachmc.breachcore.exception;

/**
 * Copyright (c) 2015, Experminator.
 */
public class BreachException extends RuntimeException {

    public BreachException() {
        super();
    }

    public BreachException(String message) {
        super(message);
    }

    public BreachException(String message, Throwable cause) {
        super(message, cause);
    }

    public BreachException(Throwable cause) {
        super(cause);
    }

    public BreachException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

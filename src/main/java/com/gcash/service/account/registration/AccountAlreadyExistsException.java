package com.gcash.service.account.registration;

public class AccountAlreadyExistsException extends Exception {
    public AccountAlreadyExistsException() {
    }

    public AccountAlreadyExistsException(String message) {
        super(message);
    }

    public AccountAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public AccountAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

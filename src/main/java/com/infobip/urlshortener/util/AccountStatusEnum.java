package com.infobip.urlshortener.util;

/**
 * @author Prasenjit Karmakar
 */
public enum AccountStatusEnum {
    OPENED("Your account is opened"),
    EXISTS("Account with that ID already exists");
    private String message;

    AccountStatusEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

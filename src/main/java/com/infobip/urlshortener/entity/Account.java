package com.infobip.urlshortener.entity;

/**
 * @author Prasenjit Karmakar
 */
public class Account {
    private final String accountId;
    private String password;

    public Account(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

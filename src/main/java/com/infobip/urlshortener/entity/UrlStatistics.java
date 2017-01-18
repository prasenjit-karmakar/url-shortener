package com.infobip.urlshortener.entity;

/**
 * @author Prasenjit Karmakar
 */
public class UrlStatistics {
    private final String accountId;
    private final String url;

    public UrlStatistics(String accountId, String url) {
        this.accountId = accountId;
        this.url = url;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUrl() {
        return url;
    }
}

package com.infobip.urlshortener.entity;

/**
 * @author Prasenjit Karmakar
 */
public class UrlMapping implements Comparable {
    private final String url;
    private final String shortUrl;
    private final String accountId;
    private final Integer redirectType;

    public UrlMapping(String url, String shortUrl, String accountId, Integer redirectType) {
        this.url = url;
        this.shortUrl = shortUrl;
        this.accountId = accountId;
        this.redirectType = redirectType;
    }

    public String getUrl() {
        return url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getAccountId() {
        return accountId;
    }

    public Integer getRedirectType() {
        return redirectType;
    }

    @Override
    public int compareTo(Object o) {
        UrlMapping url = (UrlMapping) o;
        return url.getUrl().compareTo(this.url);
    }
}

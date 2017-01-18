package com.infobip.urlshortener.repository;

import com.infobip.urlshortener.entity.UrlMapping;

/**
 * @author Prasenjit Karmakar
 */
public interface UrlRepository {
    boolean registerUrl(UrlMapping urlMapping);
    UrlMapping getUrlMapping(String shortUrl);
}

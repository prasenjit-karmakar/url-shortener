package com.infobip.urlshortener.repository;

import com.infobip.urlshortener.entity.UrlMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Prasenjit Karmakar
 */
public class UrlRepositoryImpl implements UrlRepository {
    private final static Map<String, UrlMapping> urlMap = new ConcurrentHashMap<>();

    @Override
    public boolean registerUrl(UrlMapping urlMapping) {
        urlMap.put(urlMapping.getShortUrl(), urlMapping);
        return true;
    }

    @Override
    public UrlMapping getUrlMapping(String shortUrl) {
        return urlMap.get(shortUrl);
    }

}

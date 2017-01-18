package com.infobip.urlshortener.repository;

import com.infobip.urlshortener.entity.UrlMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

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

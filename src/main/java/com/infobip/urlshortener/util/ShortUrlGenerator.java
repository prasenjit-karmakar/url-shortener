package com.infobip.urlshortener.util;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * @author Prasenjit Karmakar
 */
public class ShortUrlGenerator {
    public static String getShortUrl(String url) {
        return  Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
    }
}

package com.infobip.urlshortener.util;

import com.google.common.hash.Hashing;
import com.google.inject.Inject;
import com.infobip.urlshortener.configuration.AppConfiguration;
import com.infobip.urlshortener.configuration.ShortUrlConfiguration;

import java.nio.charset.StandardCharsets;

/**
 * @author Prasenjit Karmakar
 */
public class ShortUrlGenerator {

    private final ShortUrlConfiguration shortUrlConfiguration;

    @Inject
    public ShortUrlGenerator(ShortUrlConfiguration shortUrlConfiguration) {
        this.shortUrlConfiguration = shortUrlConfiguration;
    }

    public static String getShortUrl(String url) {
        return  Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
    }
}

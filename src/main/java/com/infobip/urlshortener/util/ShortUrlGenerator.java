package com.infobip.urlshortener.util;

import com.google.inject.Inject;
import com.infobip.urlshortener.configuration.AppConfiguration;
import com.infobip.urlshortener.configuration.ShortUrlConfiguration;

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
        return "";
    }
}

package com.infobip.urlshortener.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * @author Prasenjit Karmakar
 */
public class ShortUrlConfiguration {

    @NotNull
    private final String baseUrl;

    public ShortUrlConfiguration(@JsonProperty("baseUrl") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}

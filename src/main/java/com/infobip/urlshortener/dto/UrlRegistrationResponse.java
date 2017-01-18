package com.infobip.urlshortener.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Prasenjit karmakar
 */
public class UrlRegistrationResponse {
    @NotEmpty
    @NotBlank
    private final String shortUrl;

    @JsonCreator
    public UrlRegistrationResponse(@JsonProperty("shortUrl") String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}

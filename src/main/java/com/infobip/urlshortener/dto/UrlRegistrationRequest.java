package com.infobip.urlshortener.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Prasenjit karmakar
 */
public class UrlRegistrationRequest {
    @NotBlank
    @NotEmpty
    private final String url;
    private final int redirectType;

    @JsonCreator
    public UrlRegistrationRequest(@JsonProperty("url") String url,@JsonProperty("redirectType") int redirectType) {
        this.url = url;
        this.redirectType = redirectType;
    }

    public String getUrl() {
        return url;
    }

    public int getRedirectType() {
        return redirectType;
    }
}

package com.infobip.urlshortener.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author Prasenjit Karmakar
 */
public class AppConfiguration extends Configuration {

    @NotNull
    private final int passwordLength;
    @NotNull
    private final String defaultName;
    @NotNull
    private final ShortUrlConfiguration shortUrlConfig;


    public AppConfiguration(@JsonProperty("passwordLength") int passwordLength,
                            @JsonProperty("defaultName") String defaultName,
                            @JsonProperty("shortUrlConfig") ShortUrlConfiguration shortUrlConfig) {
        this.passwordLength = passwordLength;
        this.defaultName = defaultName;
        this.shortUrlConfig = shortUrlConfig;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public ShortUrlConfiguration getShortUrlConfig() {
        return shortUrlConfig;
    }
}

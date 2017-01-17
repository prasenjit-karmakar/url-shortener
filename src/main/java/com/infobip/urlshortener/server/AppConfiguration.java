package com.infobip.urlshortener.server;

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

    public AppConfiguration(@JsonProperty("passwordLength") int passwordLength,
                            @JsonProperty("defaultName") String defaultName) {
        this.passwordLength = passwordLength;
        this.defaultName = defaultName;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public String getDefaultName() {
        return defaultName;
    }
}

package com.infobip.urlshortener.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Prasenjit Karmakar
 */
public class AccountCreationResponse {
    @NotEmpty
    @NotBlank
    private final boolean success;
    @NotEmpty
    @NotBlank
    private final String description;

    @JsonCreator
    public AccountCreationResponse(@JsonProperty("success") boolean success,
                                   @JsonProperty("description") String description) {
        this.success = success;
        this.description = description;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getDescription() {
        return description;
    }
}

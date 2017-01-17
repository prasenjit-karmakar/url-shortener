package com.infobip.urlshortener.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Prasenjit Karmakar
 */
public class AccountCreationSuccessResponse extends AccountCreationResponse {
    @NotEmpty
    @NotBlank
    private final String password;

    public AccountCreationSuccessResponse(@JsonProperty("success") boolean success, @JsonProperty("description") String description,
                                          @JsonProperty("password") String password) {
        super(success, description);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

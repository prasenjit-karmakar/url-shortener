package com.infobip.urlshortener.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Prasenjit Karmakar
 */
public class AccountCreationRequest {
    @NotBlank
    @NotEmpty
    private final String accountId;

    @JsonCreator
    public AccountCreationRequest(@JsonProperty("AccountId") String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }
}

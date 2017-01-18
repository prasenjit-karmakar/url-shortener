package com.infobip.urlshortener.service;

import com.google.inject.Inject;
import com.infobip.urlshortener.configuration.AppConfiguration;
import com.infobip.urlshortener.dto.AccountCreationRequest;
import com.infobip.urlshortener.dto.AccountCreationResponse;
import com.infobip.urlshortener.dto.AccountCreationSuccessResponse;
import com.infobip.urlshortener.entity.Account;
import com.infobip.urlshortener.repository.AccountRepository;
import com.infobip.urlshortener.repository.AccountRepositoryImpl;
import com.infobip.urlshortener.util.AccountStatusEnum;
import io.dropwizard.auth.basic.BasicCredentials;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Optional;

/**
 * @author Prasenjit Karmakar
 */
public class AccountService {
    private final static AccountRepository accountRepository = new AccountRepositoryImpl();
    private final AppConfiguration configuration;

    @Inject
    public AccountService(AppConfiguration configuration) {
        this.configuration = configuration;
    }

    public AccountCreationResponse createAccount(AccountCreationRequest accountCreationRequest) {
        Account account = new Account(accountCreationRequest.getAccountId(), RandomStringUtils.randomAlphanumeric(configuration.getPasswordLength()));
        boolean isCreated = accountRepository.createAccount(account);
        if (isCreated)
            return new AccountCreationSuccessResponse(true, AccountStatusEnum.OPENED.getMessage(), account.getPassword());
        else
            return new AccountCreationResponse(false, AccountStatusEnum.EXISTS.getMessage());
    }

    public static  boolean isValidCredentials(BasicCredentials basicCredentials) {
        boolean isValidCredentials = false;
        Optional<Account> account = accountRepository.getAccountById(basicCredentials.getUsername());
        if (account.isPresent() && account.get().getPassword().equals(basicCredentials.getPassword())) {
            isValidCredentials = true;
        }
        return isValidCredentials;
    }
}

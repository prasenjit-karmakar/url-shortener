package com.infobip.urlshortener.service;

import com.google.inject.Inject;
import com.infobip.urlshortener.dto.AccountCreationRequest;
import com.infobip.urlshortener.dto.AccountCreationResponse;
import com.infobip.urlshortener.dto.AccountCreationSuccessResponse;
import com.infobip.urlshortener.entity.Account;
import com.infobip.urlshortener.repository.AccountRepository;
import com.infobip.urlshortener.server.AppConfiguration;
import com.infobip.urlshortener.util.AccountStatusEnum;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Prasenjit Karmakar
 */
public class AccountService {
    final static Logger logger = LoggerFactory.getLogger(AccountService.class);
    private final AccountRepository accountRepository;
    private final AppConfiguration configuration;

    @Inject
    public AccountService(AccountRepository accountRepository, AppConfiguration configuration) {
        this.accountRepository = accountRepository;
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
}

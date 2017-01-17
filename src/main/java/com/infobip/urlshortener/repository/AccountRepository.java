package com.infobip.urlshortener.repository;


import com.infobip.urlshortener.entity.Account;

import java.util.Optional;

/**
 * @author Prasenjit Karmakar
 */
public interface AccountRepository {
    Optional<Account> getAccountById(String accountId);

    boolean createAccount(Account account);
}

package com.infobip.urlshortener.repository;

import com.infobip.urlshortener.entity.Account;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Prasenjit Karmakar
 */
public class AccountRepositoryImpl implements AccountRepository {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    @Override
    public Optional<Account> getAccountById(String accountId) {
        return accounts.get(accountId) != null ? Optional.of(accounts.get(accountId)) : Optional.empty();
    }

    @Override
    public boolean createAccount(Account account) {
        boolean isCreated = false;
        if (!getAccountById(account.getAccountId()).isPresent()) {
            accounts.put(account.getAccountId(), account);
            isCreated = true;

        }
        return isCreated;
    }
}

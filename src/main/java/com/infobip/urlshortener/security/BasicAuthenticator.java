package com.infobip.urlshortener.security;

import com.infobip.urlshortener.service.AccountService;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Optional;

/**
 * @author Prasenjit Karmakar
 */
public class BasicAuthenticator implements Authenticator<BasicCredentials, User> {

    @Override
    public Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        if (AccountService.isValidCredentials(basicCredentials)) {
            return Optional.of(new User(basicCredentials.getUsername()));
        }
        return Optional.empty();
    }
}

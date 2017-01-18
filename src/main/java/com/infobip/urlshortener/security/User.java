package com.infobip.urlshortener.security;

import java.security.Principal;

/**
 * @author Prasenjit karmakar
 */
public class User implements Principal {

    private final String id;

    public User(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return id;
    }
}

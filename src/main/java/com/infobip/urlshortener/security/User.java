package com.infobip.urlshortener.security;

import java.security.Principal;

/**
 * @author Prasenjit karmakar
 */
public class User implements Principal {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

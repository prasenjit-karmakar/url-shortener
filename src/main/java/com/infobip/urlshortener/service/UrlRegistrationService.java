package com.infobip.urlshortener.service;

import com.google.inject.Inject;
import com.infobip.urlshortener.dto.UrlRegistrationRequest;
import com.infobip.urlshortener.dto.UrlRegistrationResponse;
import com.infobip.urlshortener.entity.UrlMapping;
import com.infobip.urlshortener.repository.UrlRepository;
import com.infobip.urlshortener.security.User;
import com.infobip.urlshortener.util.ShortUrlGenerator;

import javax.ws.rs.core.Response;

/**
 * @author Prasenjit karmakar
 */
public class UrlRegistrationService {
    private final UrlRepository urlRepository;

    @Inject
    public UrlRegistrationService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public UrlRegistrationResponse registerUrl(UrlRegistrationRequest registrationRequest, User user) {
        String shortenedUrl = ShortUrlGenerator.getShortUrl(registrationRequest.getUrl());
        boolean isRegistered = urlRepository.registerUrl(new UrlMapping(registrationRequest.getUrl(), shortenedUrl, user.getName(), getRedirectType(registrationRequest.getRedirectType())));
        if (isRegistered)
            return new UrlRegistrationResponse(shortenedUrl);
        else
            return new UrlRegistrationResponse("");
    }

    private int getRedirectType(Integer redirectType) {
        if (redirectType != null && (redirectType.equals(Response.Status.FOUND.getStatusCode()) ||
                redirectType.equals(Response.Status.MOVED_PERMANENTLY.getStatusCode()))) {
            return redirectType;
        } else
            return Response.Status.FOUND.getStatusCode();
    }
}
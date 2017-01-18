package com.infobip.urlshortener.service;

import com.google.inject.Inject;
import com.infobip.urlshortener.configuration.ShortUrlConfiguration;
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
    private final ShortUrlConfiguration shortUrlConfiguration;

    @Inject
    public UrlRegistrationService(UrlRepository urlRepository, ShortUrlConfiguration shortUrlConfiguration) {
        this.urlRepository = urlRepository;
        this.shortUrlConfiguration = shortUrlConfiguration;
    }

    public UrlRegistrationResponse registerUrl(UrlRegistrationRequest registrationRequest, User user) {
        String shortenedUrl = shortUrlConfiguration.getBaseUrl()
                .concat(ShortUrlGenerator.getShortUrl(registrationRequest.getUrl()));
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
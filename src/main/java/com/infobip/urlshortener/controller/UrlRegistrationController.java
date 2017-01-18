package com.infobip.urlshortener.controller;

import com.google.inject.Inject;
import com.infobip.urlshortener.dto.UrlRegistrationRequest;
import com.infobip.urlshortener.dto.UrlRegistrationResponse;
import com.infobip.urlshortener.security.User;
import com.infobip.urlshortener.service.UrlRegistrationService;
import io.dropwizard.auth.Auth;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Prasenjit Karmakar
 */
@Path("/register")
@Produces(MediaType.APPLICATION_JSON)
public class UrlRegistrationController {
    private final UrlRegistrationService urlRegistrationService;

    @Inject
    public UrlRegistrationController(UrlRegistrationService urlRegistrationService) {
        this.urlRegistrationService = urlRegistrationService;
    }

    @PermitAll
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UrlRegistrationResponse registerUrl(@Valid UrlRegistrationRequest registrationRequest, @Auth User user) {
        return urlRegistrationService.registerUrl(registrationRequest, user);
    }
}

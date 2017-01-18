package com.infobip.urlshortener.controller;

import com.google.inject.Inject;
import com.infobip.urlshortener.dto.AccountCreationRequest;
import com.infobip.urlshortener.dto.AccountCreationResponse;
import com.infobip.urlshortener.service.AccountService;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Prasenjit Karmakar
 */
@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {

    private final AccountService accountService;

    @Inject
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @POST
    @Consumes("application/json")
    public Response createAccount(@Valid AccountCreationRequest accountCreationRequest) {
        AccountCreationResponse response = accountService.createAccount(accountCreationRequest);
        if (response.isSuccess()) {
            return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON_TYPE).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity(response).type(MediaType.APPLICATION_JSON_TYPE).build();
        }
    }
}

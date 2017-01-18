package com.infobip.urlshortener.controller;

import com.google.inject.Inject;
import com.infobip.urlshortener.entity.UrlMapping;
import com.infobip.urlshortener.service.UrlRedirectionService;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * @author Prasenjit karmakar
 */
@Path("/")
public class UrlRedirectionController {
    private final UrlRedirectionService urlRedirectionService;

    @Inject
    public UrlRedirectionController(UrlRedirectionService urlRedirectionService) {
        this.urlRedirectionService = urlRedirectionService;
    }

    @GET
    @Path("/{shortUrl}")
    public Response redirect(@PathParam("shortUrl") String shortUrl, HttpServletResponse response) {
        UrlMapping urlMapping = urlRedirectionService.getUrlMapping(shortUrl);
        if (urlMapping != null) {
            try {
                response.sendRedirect(urlMapping.getUrl());
            } catch (IOException e) {
                return Response.status(Response.Status.NOT_FOUND).entity(Response.Status.NOT_FOUND.name()).type(MediaType.APPLICATION_JSON_TYPE).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity(Response.Status.NOT_FOUND.name()).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}

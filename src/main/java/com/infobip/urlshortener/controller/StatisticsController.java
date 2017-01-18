package com.infobip.urlshortener.controller;


import com.google.inject.Inject;
import com.infobip.urlshortener.security.User;
import com.infobip.urlshortener.service.StatisticsService;
import io.dropwizard.auth.Auth;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * @author Prasenjit Karmakar
 */
@Path("/statistic")
public class StatisticsController {
    private final StatisticsService statisticsService;

    @Inject
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GET
    @Path("/{AccountId}")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Long> getStatistics(@PathParam("AccountId") String accountId, @Auth User user) {
        if (accountId.equals(user.getName())) {
            return statisticsService.getStatistics(accountId);
        } else
            throw new WebApplicationException(Response.Status.UNAUTHORIZED.name(), Response.Status.UNAUTHORIZED.getStatusCode());
    }
}

package com.infobip.urlshortener.controller;


import com.google.inject.Inject;
import com.infobip.urlshortener.service.StatisticsService;
import com.infobip.urlshortener.service.UrlRegistrationService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Consumes("application/json")
    public Map<String, Integer> getStatistics(@PathParam("AccountId") String accountId) {
        return null;
    }
}

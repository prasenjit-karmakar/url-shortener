package com.infobip.urlshortener.server;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author Prasenjit Karmakar
 */
public class AppHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        try{
            return Result.healthy();
        }catch(Exception e){
            return Result.unhealthy("check.");
        }
    }
}

package com.infobip.urlshortener.server;

import ch.qos.logback.core.joran.spi.JoranException;
import com.google.inject.Injector;
import com.infobip.urlshortener.configuration.AppConfiguration;
import com.infobip.urlshortener.controller.AccountController;
import com.infobip.urlshortener.controller.StatisticsController;
import com.infobip.urlshortener.controller.UrlRedirectionController;
import com.infobip.urlshortener.controller.UrlRegistrationController;
import com.infobip.urlshortener.security.BasicAuthenticator;
import com.infobip.urlshortener.security.User;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Prasenjit Karmakar
 */
public abstract class Server extends Application<AppConfiguration> {
    @Override
    public String getName() {
        return "url-shortener";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {

    }
    @Override
    public void run(AppConfiguration configuration,
                    Environment environment) throws JoranException {
        Injector injector = createInjector(configuration, environment);
        environment.jersey().register(injector.getInstance(AccountController.class));
        environment.jersey().register(injector.getInstance(UrlRegistrationController.class));
        environment.jersey().register(injector.getInstance(StatisticsController.class));
        environment.jersey().register(injector.getInstance(UrlRedirectionController.class));
        environment.healthChecks().register("template", injector.getInstance(AppHealthCheck.class));
        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new BasicAuthenticator())
                .setRealm("BASIC-AUTH-REALM")
                .buildAuthFilter()));
      /*  FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,OPTIONS,PUT");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "*//*");*/
    }

    abstract Injector createInjector(final AppConfiguration configuration, final Environment environment);
}

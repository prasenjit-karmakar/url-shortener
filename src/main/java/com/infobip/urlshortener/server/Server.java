package com.infobip.urlshortener.server;

import ch.qos.logback.core.joran.spi.JoranException;
import com.google.inject.Injector;
import com.infobip.urlshortener.configuration.AppConfiguration;
import com.infobip.urlshortener.controller.*;
import com.infobip.urlshortener.security.BasicAuthenticator;
import com.infobip.urlshortener.security.User;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
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
        environment.jersey().register(injector.getInstance(ViewController.class));
        environment.healthChecks().register("template", injector.getInstance(AppHealthCheck.class));
        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new BasicAuthenticator())
                .setRealm("BASIC-AUTH-REALM")
                .buildAuthFilter()));
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
    }

    abstract Injector createInjector(final AppConfiguration configuration, final Environment environment);
}

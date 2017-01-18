package com.infobip.urlshortener.server;

import com.google.inject.AbstractModule;
import com.infobip.urlshortener.configuration.AppConfiguration;
import com.infobip.urlshortener.configuration.ShortUrlConfiguration;
import com.infobip.urlshortener.repository.*;
import io.dropwizard.setup.Environment;

/**
 * @author Prasenjit Karmakar
 */
public class AppModule extends AbstractModule {

    private final AppConfiguration configuration;
    private final Environment environment;

    public AppModule(AppConfiguration configuration, Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        bind(AppConfiguration.class).toInstance(configuration);
        bind(ShortUrlConfiguration.class).toInstance(configuration.getShortUrlConfig());
        bind(AccountRepository.class).to(AccountRepositoryImpl.class);
        bind(UrlRepository.class).to(UrlRepositoryImpl.class);
        bind(UrlStatisticsRepository.class).to(UrlStatisticsRepositoryImpl.class);
    }
}

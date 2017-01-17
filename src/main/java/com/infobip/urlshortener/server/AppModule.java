package com.infobip.urlshortener.server;

import com.google.inject.AbstractModule;
import com.infobip.urlshortener.repository.AccountRepository;
import com.infobip.urlshortener.repository.AccountRepositoryImpl;
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
        bind(AccountRepository.class).to(AccountRepositoryImpl.class);

    }
}

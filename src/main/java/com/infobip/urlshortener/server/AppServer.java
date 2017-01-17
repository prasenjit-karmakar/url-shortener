package com.infobip.urlshortener.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.setup.Environment;

/**
 * @author Prasenjit Karmakar
 */
public class AppServer extends Server{
    public static void main(String[] args) throws Exception {
        new AppServer().run(args);
    }
    @Override
    Injector createInjector(AppConfiguration configuration, Environment environment) {
        return Guice.createInjector(new AppModule(configuration, environment));
    }
}

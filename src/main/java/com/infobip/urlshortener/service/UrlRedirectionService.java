package com.infobip.urlshortener.service;

import com.google.inject.Inject;
import com.infobip.urlshortener.configuration.ShortUrlConfiguration;
import com.infobip.urlshortener.entity.UrlMapping;
import com.infobip.urlshortener.repository.UrlRepository;

/**
 * @author Prasenjit karmakar
 */
public class UrlRedirectionService {
    private final UrlRepository urlRepository;
    private final StatisticsService statisticsService;
    private final ShortUrlConfiguration shortUrlConfiguration;

    @Inject
    public UrlRedirectionService(UrlRepository urlRepository, StatisticsService statisticsService, ShortUrlConfiguration shortUrlConfiguration) {
        this.urlRepository = urlRepository;
        this.statisticsService = statisticsService;
        this.shortUrlConfiguration = shortUrlConfiguration;
    }

    public UrlMapping getUrlMapping(String shortUrl) {
        UrlMapping urlMapping = urlRepository.getUrlMapping(shortUrlConfiguration.getBaseUrl().concat(shortUrl));
        if (urlMapping != null) {
            statisticsService.updateStatistics(urlMapping.getAccountId(), urlMapping.getUrl());
        }
        return urlMapping;
    }


}
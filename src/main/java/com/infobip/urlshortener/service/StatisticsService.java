package com.infobip.urlshortener.service;

import com.google.inject.Inject;
import com.infobip.urlshortener.repository.UrlStatisticsRepository;

import java.util.Map;

/**
 * @author Prasenjit Karmakar
 */
public class StatisticsService {
    private final UrlStatisticsRepository urlStatisticsRepository;

    @Inject
    public StatisticsService(UrlStatisticsRepository urlStatisticsRepository) {
        this.urlStatisticsRepository = urlStatisticsRepository;
    }

    public Map<String, Long> getStatistics(String accountId) {
        return urlStatisticsRepository.getStatistics(accountId);
    }

    public void updateStatistics(String accountId, String url) {
        urlStatisticsRepository.updateStatistics(accountId, url);
    }
}

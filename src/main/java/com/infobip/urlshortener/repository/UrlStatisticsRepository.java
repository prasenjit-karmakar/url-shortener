package com.infobip.urlshortener.repository;

import java.util.Map;

/**
 * @author Prasenjit Karmakar
 */
public interface UrlStatisticsRepository {
    Map<String,Long> getStatistics(String accountId);
    void updateStatistics(String accountId, String url);
}

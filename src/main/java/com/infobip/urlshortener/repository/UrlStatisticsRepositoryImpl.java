package com.infobip.urlshortener.repository;

import com.infobip.urlshortener.entity.UrlStatistics;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Prasenjit Karmakar
 */
public class UrlStatisticsRepositoryImpl implements UrlStatisticsRepository {
    private final List<UrlStatistics> urlStatistics = new LinkedList<>();

    @Override
    public Map<String, Integer> getStatistics(String accountId) {
        return null;
    }

    @Override
    public void updateStatistics(String accountId, String url) {
        urlStatistics.add(new UrlStatistics(accountId, url));
    }
}

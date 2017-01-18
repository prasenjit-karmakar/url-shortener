package com.infobip.urlshortener.repository;

import com.infobip.urlshortener.entity.UrlStatistics;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Prasenjit Karmakar
 */
public class UrlStatisticsRepositoryImpl implements UrlStatisticsRepository {
    private final static List<UrlStatistics> urlStatistics = new LinkedList<>();

    @Override
    public Map<String, Long> getStatistics(String accountId) {
        return urlStatistics.stream().filter(t -> t.getAccountId().equals(accountId))
                .collect(Collectors.groupingBy(UrlStatistics::getUrl, Collectors.counting()));
    }

    @Override
    public void updateStatistics(String accountId, String url) {
        urlStatistics.add(new UrlStatistics(accountId, url));
    }
}

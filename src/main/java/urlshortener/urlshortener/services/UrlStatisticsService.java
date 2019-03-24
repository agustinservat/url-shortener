package urlshortener.urlshortener.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urlshortener.urlshortener.models.UrlStatistics;
import urlshortener.urlshortener.repositories.UrlStatisticsRepository;
import urlshortener.urlshortener.repositories.projections.UrlStatisticsGroupBy;
import urlshortener.urlshortener.repositories.projections.UrlStatisticsReport;

import java.util.List;

@Service
public class UrlStatisticsService {

    @Autowired
    private UrlStatisticsRepository urlStatisticsRepository;

    public List<UrlStatistics> getAll(){
        return urlStatisticsRepository.findAll();
    }

    public UrlStatistics save(UrlStatistics urlStatistics){
        return urlStatisticsRepository.save(urlStatistics);
    }

    public List<UrlStatisticsGroupBy> getRemoteAdrrCount(){
        return urlStatisticsRepository.findRemoteAdrrCount();
    }

    public List<UrlStatisticsGroupBy> getUserAgentCount(){
        return urlStatisticsRepository.findUserAgentCount();
    }

    public List<UrlStatisticsGroupBy> getMonthVisited(){
        return urlStatisticsRepository.monthVisited();
    }

    public List<UrlStatisticsGroupBy> getUrlMostVisited(){
        return urlStatisticsRepository.urlMostVisited();
    }

    public List<UrlStatisticsGroupBy> getShortenedMostVisited(){
        return urlStatisticsRepository.shortenedMostVisited();
    }

    public List<UrlStatisticsReport> getUrlReport(){
        return urlStatisticsRepository.urlReport();
    }

}

package urlshortener.urlshortener.repositories.projections;

public interface UrlStatisticsReport {

    String getUrl();
    Integer getAllways();
    Integer getVisitedYesterday();
    Integer getVisitedLastWeek();
    Integer getVisitedYesterMonth();
}

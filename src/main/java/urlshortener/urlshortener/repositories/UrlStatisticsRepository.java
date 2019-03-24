package urlshortener.urlshortener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import urlshortener.urlshortener.models.UrlStatistics;
import urlshortener.urlshortener.repositories.projections.UrlStatisticsGroupBy;
import urlshortener.urlshortener.repositories.projections.UrlStatisticsReport;

import java.util.List;

@Repository
public interface UrlStatisticsRepository extends JpaRepository<UrlStatistics, Integer> {

    @Query(value = "select s.remote_addr as name, count(s.id) as cnt from url_statistics s group by s.remote_addr order by cnt desc;", nativeQuery = true)
    List<UrlStatisticsGroupBy> findRemoteAdrrCount();

    @Query(value = "select s.user_agent_info as name, count(s.id) as cnt from url_statistics s group by s.user_agent_info order by cnt desc;", nativeQuery = true)
    List<UrlStatisticsGroupBy> findUserAgentCount();

    @Query(value = "select MONTH(s.date) as name, count(s.id) as cnt\n" +
            "from url_statistics s\n" +
            "group by MONTH(s.date) order by cnt desc;", nativeQuery = true)
    List<UrlStatisticsGroupBy> monthVisited();

    @Query(value = "select m.url as name, count(m.id) as cnt\n" +
            "from url_statistics s join url_manager m on (s.url_input = m.url or s.url_input = m.shortened)\n" +
            "group by m.url\n" +
            "order by cnt desc;", nativeQuery = true)
    List<UrlStatisticsGroupBy> urlMostVisited();

    @Query(value = "select m.url as name, count(m.id) as cnt\n" +
            "from url_statistics s join url_manager m on (s.url_input = m.shortened)\n" +
            "group by m.url\n" +
            "order by cnt desc;", nativeQuery = true)
    List<UrlStatisticsGroupBy> shortenedMostVisited();

    @Query(value = "SELECT\n" +
            "  m.url,\n" +
            "  COUNT(*) allways,\n" +
            "  COUNT(CASE WHEN DATE(s.date) = CURDATE() THEN 1 END) AS visitedToday,\n" +
            "  COUNT(CASE WHEN DATEDIFF(CURDATE(), s.date) = 1 THEN 1 END) AS visitedYesterday,\n" +
            "  COUNT(CASE WHEN DATEDIFF(CURDATE(), s.date) BETWEEN 2 AND 7 THEN 1 END) AS visitedLastWeek,\n" +
            "  COUNT(CASE WHEN DATEDIFF(CURDATE(), s.date) BETWEEN 8 AND 30 THEN 1 END) AS visitedYesterMonth\n" +
            "FROM\n" +
            "  url_statistics s join url_manager m on (s.url_input = m.url or s.url_input = m.shortened)\n" +
            "GROUP BY\n" +
            "  m.url\n" +
            "ORDER BY allways desc;", nativeQuery = true)
    List<UrlStatisticsReport> urlReport();


}

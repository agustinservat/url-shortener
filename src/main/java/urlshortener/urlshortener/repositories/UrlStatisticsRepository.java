package urlshortener.urlshortener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import urlshortener.urlshortener.models.UrlStatistics;
import urlshortener.urlshortener.repositories.projections.UrlStatisticsGroupBy;

import java.util.Calendar;
import java.util.List;

@Repository
public interface UrlStatisticsRepository extends JpaRepository<UrlStatistics, Integer> {


//    UrlStatistics findByUserAgentInfo(String userAgentInfo);
//    UrlStatistics findByRemoteAddr(String remoteAddr);
//    UrlStatistics findByDate(Calendar date);
//    select new map(count(v) as cnt, v.answer) from Survey v group by v.answer
//    @Query("select new Map(s.remoteAddr, count(s)) from UrlStatistics s group by s.remoteAddr")
//    List<Map<String, Integer>> findRemoteAdrrCount();

    @Query(value = "select s.remote_addr as name, count(s.id) as cnt from url_statistics s group by s.remote_addr order by cnt desc;", nativeQuery = true)
    List<UrlStatisticsGroupBy> findRemoteAdrrCount();

    @Query(value = "select s.user_agent_info as name, count(s.id) as cnt from url_statistics s group by s.user_agent_info order by cnt desc;", nativeQuery = true)
    List<UrlStatisticsGroupBy> findUserAgentCount();

    @Query(value = "select MONTH(s.date) as name, count(s.id) as cnt\n" +
            "from url_statistics s\n" +
            "group by MONTH(s.date) order by cnt desc;", nativeQuery = true)
    List<UrlStatisticsGroupBy> monthVisited();

//    SELECT
//    s.url_input,
//    COUNT(*) Allways,
//    COUNT(CASE WHEN DATE(s.date) = CURDATE() THEN 1 END) AS VisitedToday,
//    COUNT(CASE WHEN DATEDIFF(CURDATE(), s.date) = 1 THEN 1 END) AS VisitedYesterday,
//    COUNT(CASE WHEN DATEDIFF(CURDATE(), s.date) BETWEEN 2 AND 7 THEN 1 END) AS VisitedLastWeek,
//    COUNT(CASE WHEN DATEDIFF(CURDATE(), s.date) BETWEEN 8 AND 30 THEN 1 END) AS VisitedYesterMonth
//    FROM
//    url_statistics s
//    GROUP BY
//    s.url_input


}

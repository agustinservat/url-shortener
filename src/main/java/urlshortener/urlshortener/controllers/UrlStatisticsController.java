package urlshortener.urlshortener.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import urlshortener.urlshortener.models.UrlStatistics;
import urlshortener.urlshortener.repositories.projections.UrlStatisticsGroupBy;
import urlshortener.urlshortener.services.UrlStatisticsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class UrlStatisticsController {

    @Autowired
    private UrlStatisticsService urlStatisticsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatistics>> findAll(){
        return new ResponseEntity<List<UrlStatistics>>(urlStatisticsService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/remote-adrr-cnt", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatisticsGroupBy>> getRemoteAdrrCount(){

        return new ResponseEntity<List<UrlStatisticsGroupBy>>(urlStatisticsService.getRemoteAdrrCount(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user-agent-cnt", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatisticsGroupBy>> getUserAgentCount(){

        return new ResponseEntity<List<UrlStatisticsGroupBy>>(urlStatisticsService.getUserAgentCount(), HttpStatus.OK);
    }

    @RequestMapping(value = "/month-visited-cnt", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatisticsGroupBy>> geMonthVisited(){

        return new ResponseEntity<List<UrlStatisticsGroupBy>>(urlStatisticsService.getMonthVisited(), HttpStatus.OK);
    }
}

package urlshortener.urlshortener.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import urlshortener.urlshortener.repositories.projections.UrlStatisticsGroupBy;
import urlshortener.urlshortener.repositories.projections.UrlStatisticsReport;
import urlshortener.urlshortener.services.UrlStatisticsService;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class UrlStatisticsController {

    @Autowired
    private UrlStatisticsService urlStatisticsService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ResponseEntity<List<UrlStatistics>> findAll(){
//        return new ResponseEntity<List<UrlStatistics>>(urlStatisticsService.getAll(), HttpStatus.OK);
//    }

    @RequestMapping(value = "/adrr-visited", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatisticsGroupBy>> getRemoteAdrrCount(){

        return new ResponseEntity<List<UrlStatisticsGroupBy>>(urlStatisticsService.getRemoteAdrrCount(), HttpStatus.OK);
    }

    @RequestMapping(value = "/agent-visited", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatisticsGroupBy>> getUserAgentCount(){

        return new ResponseEntity<List<UrlStatisticsGroupBy>>(urlStatisticsService.getUserAgentCount(), HttpStatus.OK);
    }

    @RequestMapping(value = "/month-visited", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatisticsGroupBy>> getMonthVisited(){

        return new ResponseEntity<List<UrlStatisticsGroupBy>>(urlStatisticsService.getMonthVisited(), HttpStatus.OK);
    }

    @RequestMapping(value = "/url-visited", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatisticsGroupBy>> getUrlMostVisited(){

        return new ResponseEntity<List<UrlStatisticsGroupBy>>(urlStatisticsService.getUrlMostVisited(), HttpStatus.OK);
    }

    @RequestMapping(value = "/shortened-visited", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatisticsGroupBy>> getShortenedMostVisited(){

        return new ResponseEntity<List<UrlStatisticsGroupBy>>(urlStatisticsService.getShortenedMostVisited(), HttpStatus.OK);
    }

    @RequestMapping(value = "/url-report", method = RequestMethod.GET)
    public ResponseEntity<List<UrlStatisticsReport>> getUrlReport(){

        return new ResponseEntity<List<UrlStatisticsReport>>(urlStatisticsService.getUrlReport(), HttpStatus.OK);
    }
}

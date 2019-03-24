package urlshortener.urlshortener.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urlshortener.urlshortener.models.UrlManager;
import urlshortener.urlshortener.models.UrlStatistics;
import urlshortener.urlshortener.services.UrlService;
import urlshortener.urlshortener.services.UrlStatisticsService;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @Autowired
    private UrlStatisticsService urlStatisticsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UrlManager>> findAll(HttpServletRequest request){

        String userAgentInfo = request.getHeader("User-Agent");
        System.out.println(request.getRemoteAddr());
        System.out.println(userAgentInfo);

        return new ResponseEntity<List<UrlManager>>(urlService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/url", method = RequestMethod.POST)
    public ResponseEntity<String> getShortByUrl(@RequestBody UrlManager url, HttpServletRequest request){

        String userAgentInfo = request.getHeader("User-Agent");


        if(isValidURL(url.getUrl())){
            String shortUrl = urlService.getShortByUrl(url.getUrl());
            //Save statistics
            Calendar cal = Calendar.getInstance();
            UrlStatistics urlStatistics = new UrlStatistics(userAgentInfo, request.getRemoteAddr(), cal, url.getUrl());
            urlStatisticsService.save(urlStatistics);

            return new ResponseEntity<String>(shortUrl, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("The URL is not valid.");
        }
    }

    @RequestMapping(value = "/{shortened}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOriginal(@PathVariable("shortened") String shortened, HttpServletRequest request){

        String userAgentInfo = request.getHeader("User-Agent");
        System.out.println(request.getRemoteAddr());
        System.out.println(userAgentInfo);

        //Save statistics
        Calendar cal = Calendar.getInstance();
        UrlStatistics urlStatistics = new UrlStatistics(userAgentInfo, request.getRemoteAddr(), cal, shortened);
        urlStatisticsService.save(urlStatistics);

        UrlManager urlManager = urlService.getOriginalByShortened(shortened);
        try {
            if(urlManager != null){
                HttpHeaders httpHeaders = new HttpHeaders();
                URI uri = new URI(urlManager.getUrl());
                httpHeaders.setLocation(uri);

                return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .contentType(MediaType.TEXT_PLAIN)
                        .body("URL not found.");
            }
        }catch (URISyntaxException e){
            System.out.println(e.getMessage());
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<>(httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public boolean isValidURL(String urlStr) {
        try {
            URL url = new URL(urlStr);
            return true;
        }
        catch (MalformedURLException e) {
            return false;
        }
    }
}

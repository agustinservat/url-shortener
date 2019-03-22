package urlshortener.urlshortener.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import urlshortener.urlshortener.models.LongURL;
import urlshortener.urlshortener.services.UrlService;

import java.util.List;

@RestController
@RequestMapping("/shortener")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<LongURL>> findAll(){

        return new ResponseEntity<List<LongURL>>(urlService.getAll(), HttpStatus.OK);
    }
}

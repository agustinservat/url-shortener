package urlshortener.urlshortener.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urlshortener.urlshortener.models.LongURL;
import urlshortener.urlshortener.models.ShortURL;
import urlshortener.urlshortener.repositories.LongURLRepository;

import java.util.List;
//import urlshortener.urlshortener.repositories.ShortURLRepository;

@Service
public class UrlService {

    private static String host = "localhost:8080/";

    @Autowired
    private LongURLRepository longURLRepository;

//    @Autowired
//    private ShortURLRepository shortURLRepository;

    public List<LongURL> getAll(){
        return longURLRepository.findAll();
    }

//    private String getShortUrl(String url){
//        LongURL longURL = longURLRepository.findByUrl(url);
//        if(longURL == null){
//            longURL = saveLongURL(new LongURL(url));
//        }
//        ShortURL shortURL = new ShortURL();
//        return "a";
//    }
//
////    private ShortURL generateShortKey(Long id){
////
////    }
//
//    public LongURL saveLongURL(LongURL longURL){
//
//        return longURLRepository.save(longURL);
//    }

}

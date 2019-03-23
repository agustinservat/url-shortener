package urlshortener.urlshortener.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urlshortener.urlshortener.models.IDConverter;
import urlshortener.urlshortener.models.UrlManager;
import urlshortener.urlshortener.repositories.UrlManagerRepository;


import java.util.List;

@Service
public class UrlService {

    private static String host = "localhost:8080/";

    @Autowired
    private UrlManagerRepository urlManagerRepository;

    public List<UrlManager> getAll(){
        return urlManagerRepository.findAll();
    }

    public String getShortByUrl(String url){

        UrlManager urlManager = urlManagerRepository.findByUrl(url);

        if(urlManager == null){
            urlManager = saveUrlManager(new UrlManager(url));
            urlManager.setShortened(generateShortened(urlManager.getId()));
            saveUrlManager(urlManager);
        }
        return this.host + urlManager.getShortened();
    }

    public UrlManager saveUrlManager(UrlManager urlManager){
        return urlManagerRepository.save(urlManager);
    }

    public String generateShortened(Integer id){

        return IDConverter.INSTANCE.generateShortened(id);
    }

    public UrlManager getOriginalByShortened(String shortened){
        return urlManagerRepository.findByShortened(shortened);
    }

}

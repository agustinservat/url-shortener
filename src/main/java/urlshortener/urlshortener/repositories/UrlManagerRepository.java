package urlshortener.urlshortener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urlshortener.urlshortener.models.UrlManager;

@Repository
public interface UrlManagerRepository extends JpaRepository<UrlManager, Integer> {

    UrlManager findByUrl(String url);
    UrlManager findByShortened(String shortened);

}

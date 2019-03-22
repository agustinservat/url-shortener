package urlshortener.urlshortener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urlshortener.urlshortener.models.LongURL;

@Repository
public interface LongURLRepository extends JpaRepository<LongURL, Long> {

    LongURL findByUrl(String url);

}

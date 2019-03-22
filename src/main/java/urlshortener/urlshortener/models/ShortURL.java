package urlshortener.urlshortener.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class ShortURL {

    private Long id;
    private String url;

    public ShortURL() {
    }

    public Long getId() {
        return id;
    }

    public ShortURL(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

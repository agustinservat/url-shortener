package urlshortener.urlshortener.models;

import javax.persistence.*;

@Entity
public class UrlManager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String url;
    private String shortened;

    public UrlManager() {
    }

    public UrlManager(String url, String shortened) {
        this.url = url;
        this.shortened = shortened;
    }

    public UrlManager(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortened() {
        return shortened;
    }

    public void setShortened(String shortened) {
        this.shortened = shortened;
    }
}

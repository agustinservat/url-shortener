package urlshortener.urlshortener.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
public class UrlStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String UserAgentInfo;
    private String RemoteAddr;
    private Calendar Date;
    private String UrlInput;


    public UrlStatistics() {
    }

    public UrlStatistics(String userAgentInfo, String remoteAddr, Calendar date, String urlInput) {
        UserAgentInfo = userAgentInfo;
        this.RemoteAddr= remoteAddr;
        Date = date;
        UrlInput = urlInput;
    }

    public String getUrlInput() {
        return UrlInput;
    }

    public void setUrlInput(String urlInput) {
        UrlInput = urlInput;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAgentInfo() {
        return UserAgentInfo;
    }

    public void setUserAgentInfo(String userAgentInfo) {
        UserAgentInfo = userAgentInfo;
    }

    public String getRemoteAddr() {
        return RemoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.RemoteAddr = remoteAddr;
    }

    public Calendar getDate() {
        return Date;
    }

    public void setDate(Calendar date) {
        Date = date;
    }
}

package urlshortener.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import urlshortener.urlshortener.models.IDConverter;

@SpringBootApplication
@EnableConfigurationProperties
public class UrlShortenerApplication {


	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);

	}

}

package urlshortener.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import urlshortener.urlshortener.models.IDConverter;

@SpringBootApplication
public class UrlShortenerApplication {


	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);

	}

}

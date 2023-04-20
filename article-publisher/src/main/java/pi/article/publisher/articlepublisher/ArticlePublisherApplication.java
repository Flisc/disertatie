package pi.article.publisher.articlepublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ArticlePublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticlePublisherApplication.class, args);
	}

}

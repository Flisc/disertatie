package pi.article.publisher.articlepublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import pi.article.publisher.articlepublisher.models.Article;
import pi.article.publisher.articlepublisher.models.User;
import pi.article.publisher.articlepublisher.repositories.ArticleRepository;
import pi.article.publisher.articlepublisher.repositories.UserRepo;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class ArticlePublisherApplication implements CommandLineRunner {

	@Autowired
	private ArticleRepository repo;
	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(ArticlePublisherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Iterable<Article> all = repo.findAll();
		Iterable<User> al2l = userRepo.findAll();
	}

//	@KafkaListener(topics = "articles.published")
//	public String listens(final String in) {
//		System.out.println(in);
//		return in;
//	}

}

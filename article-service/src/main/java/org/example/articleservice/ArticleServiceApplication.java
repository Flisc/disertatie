package org.example.articleservice;

import org.example.articleservice.faker.SeedService;
import org.example.articleservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ArticleServiceApplication implements CommandLineRunner {
	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(ArticleServiceApplication.class, args);
	}

	@Override
	public void run(final String... args) {
		populateArticles(20);
	}

	public void populateArticles(final Integer noOfArticles) {
		for (int i = 0; i < noOfArticles; i++) {
			articleRepository.save(SeedService.article());
		}
	}
}

package com.example.blog;

import com.example.blog.faker.SeedService;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.service.UserService;
import org.example.articleservice.service.ArticleService;
import org.example.articleservice.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.blog", "org.example.articleservice.service"})
public class BlogApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private SeedService seedService;
	@Autowired
	private ArticleRepository articleRepository;

	private ArticleService articleService;

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(final String... args) {
//		userService.listUsers().forEach(user -> { System.out.println(user.getEmail()); });
		seedService.populateUsers(10);
		populateArticles(20);
	}

	public void populateArticles(final Integer noOfArticles) {
		for (int i = 0; i < noOfArticles; i++) {
			articleRepository.save(SeedService.article(userService.listUsers()));
		}
	}
}
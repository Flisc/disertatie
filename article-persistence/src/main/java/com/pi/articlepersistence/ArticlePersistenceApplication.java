package com.pi.articlepersistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ArticlePersistenceApplication implements CommandLineRunner {

//    @Autowired
//    private ArticleService articleService;

    public static void main(String[] args) {
        SpringApplication.run(ArticlePersistenceApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        // articleService.save(Article.builder().title("art1").build());
        // articleService.save(Article.builder().title("art2").build());
        // articleService.save(Article.builder().title("art3").build());
    }

}

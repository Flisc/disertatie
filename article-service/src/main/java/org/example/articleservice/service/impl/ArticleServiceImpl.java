package org.example.articleservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.blog.userservice.model.User;
import org.blog.userservice.service.UserService;
import org.example.articleservice.faker.SeedService;
import org.example.articleservice.model.Article;
import org.example.articleservice.repository.ArticleRepository;
import org.example.articleservice.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserService userService;

    public ArticleServiceImpl(ArticleRepository articleRepository, UserService userService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    @Override
    public Article save(final Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> listArticles() {
        return articleRepository.findAll();
    }

    @Override
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @Override
    public void publishArticle() {
        log.info("\n \t\t PUBLICARE ARTICOL --------------------");
        Article article = articleRepository.save(SeedService.article());
        // TODO: notify users in user service
        // TODO: call notification  service.
    }

}

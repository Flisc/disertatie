package org.example.articleservice.service;


import org.blog.userservice.model.User;
import org.example.articleservice.model.Article;

import java.util.List;

public interface ArticleService {
    Article save(Article article);

    List<Article> listArticles();

    List<User> listUsers();

    void publishArticle(Long userId);

}

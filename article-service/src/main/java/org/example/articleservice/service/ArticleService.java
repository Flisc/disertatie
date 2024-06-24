package org.example.articleservice.service;


import org.example.articleservice.model.Article;

import java.util.List;

public interface ArticleService {
    Article save(Article article);

    List<Article> listArticles();

    Article getArticleById(Long id);

    void publishArticle(Long userId);

}

package com.pi.articlepersistence.services;

import com.pi.articlepersistence.models.Article;

import java.util.List;

public interface ArticleService {
    Article save(Article article);

    List<Article> listArticles();

}

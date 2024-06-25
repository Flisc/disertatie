package com.example.blog.service;

import com.example.blog.model.Article;

import java.util.List;

public interface ArticleService {
    Article save(Article article);

    List<Article> listArticles();

    Article getArticleById(Long id);

}

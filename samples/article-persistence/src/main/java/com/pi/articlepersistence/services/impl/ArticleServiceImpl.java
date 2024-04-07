package com.pi.articlepersistence.services.impl;

import com.pi.articlepersistence.models.Article;
import com.pi.articlepersistence.repositories.ArticleRepository;
import com.pi.articlepersistence.services.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article save(final Article article) {
        return articleRepository.save(article);
    }

    public List<Article> listArticles() {
        return StreamSupport
                .stream(articleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}

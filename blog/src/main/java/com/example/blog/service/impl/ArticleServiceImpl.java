package com.example.blog.service.impl;

import com.example.blog.model.Article;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        return articleRepository.findAll();
    }

}

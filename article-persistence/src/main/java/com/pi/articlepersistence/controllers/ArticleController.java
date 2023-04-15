package com.pi.articlepersistence.controllers;

import com.pi.articlepersistence.models.Article;
import com.pi.articlepersistence.services.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> listArticles(){
        return articleService.listArticles();
    }
}

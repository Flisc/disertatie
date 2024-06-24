package org.example.articleservice.controller;

import org.example.articleservice.model.Article;
import org.example.articleservice.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("articles")
public class ArticleController {
    private final ArticleService articleService;
//    private final UserServiceImpl userService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
//        this.userService = userService;
    }

    @GetMapping("articles/all")
    public List<Article> listArticles() {
        return articleService.listArticles();
    }


    @GetMapping("articles/create/{userId}")
    public ResponseEntity<String> publishArticle(@PathVariable Long userId) {
        articleService.publishArticle(userId);
        return ResponseEntity.ok("Publish Article");
    }

    @GetMapping("articles/{articleId}")
    public Article getArticle(@PathVariable Long articleId) {
        return articleService.getArticleById(articleId);
    }
}

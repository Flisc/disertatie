package org.example.articleservice.controller;

import org.blog.userservice.model.User;
import org.blog.userservice.service.UserService;
import org.blog.userservice.service.impl.UserServiceImpl;
import org.example.articleservice.model.Article;
import org.example.articleservice.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("articles")
public class ArticleController {
    private final ArticleService articleService;
    private final UserServiceImpl userService;

    public ArticleController(ArticleService articleService, UserServiceImpl userService) {
        this.articleService = articleService;
        this.userService = userService;
    }

    @GetMapping()
    public List<Article> listArticles() {
        return articleService.listArticles();
    }

    @GetMapping("users")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/publish_Article")
    public ResponseEntity<String> publishArticle(){
        articleService.publishArticle();
        return ResponseEntity.ok("Publish Article");
    }
}

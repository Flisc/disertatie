package com.example.blog.controller;

import com.example.blog.model.Article;
import com.example.blog.model.User;
import com.example.blog.service.ArticleService;
import com.example.blog.service.BlogServiceImpl;
import com.example.blog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    private final UserService userService;
    private final BlogServiceImpl blogService;
    private final ArticleService articleService;
    public BlogController(final UserService userService, BlogServiceImpl blogService, ArticleService articleService) {
        this.userService = userService;
        this.blogService = blogService;
        this.articleService = articleService;
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/articles")
    public List<Article> listArticles() {
        return articleService.listArticles();
    }

    @GetMapping("/publish_Article")
    public ResponseEntity<String> publishArticle() throws Exception {
        blogService.publishArticle();
        return ResponseEntity.ok("Publish Article");
    }

    @GetMapping("/subscribeToAuthor")
    public ResponseEntity<String> subscribeToAuthor() throws Exception {
        blogService.subscribeToAuthor();
        return ResponseEntity.ok("subscribeToAuthor");
    }

    @GetMapping("/register_user")
    public ResponseEntity<String> registerUser() throws Exception {
        blogService.registerUser();
        return ResponseEntity.ok("Register User");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/test")
    public void test() throws Exception {
        userService.test();
    }
}
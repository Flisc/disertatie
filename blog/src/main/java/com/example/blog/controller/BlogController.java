package com.example.blog.controller;

import com.example.blog.model.Article;
import com.example.blog.model.User;
import com.example.blog.service.ArticleService;
import com.example.blog.service.BlogServiceImpl;
import com.example.blog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/blog/users")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/blog/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ofNullable(userService.findUserById(id));
    }

    @GetMapping("/blog/articles")
    public List<Article> listArticles() {
        return articleService.listArticles();
    }

    @GetMapping("blog/articles/new/{userId}")
    public ResponseEntity<String> publishArticle(@PathVariable Long userId) throws Exception {
        blogService.publishArticle(userId);
        return ResponseEntity.ok("Publish Article");
    }

    @GetMapping("blog/users/{currentUserId}/subscribe/{subscribedUserId}")
    public ResponseEntity<String> subscribeToAuthor(@PathVariable Long currentUserId, @PathVariable Long subscribedUserId) throws Exception {
        blogService.subscribeToAuthor(currentUserId, subscribedUserId);
        return ResponseEntity.ok("subscribeToAuthor");
    }

    @GetMapping("blog/users/{currentUserId}/unSubscribe/{subscribedUserId}")
    public ResponseEntity<String> unSubscribeFromAuthor(@PathVariable Long currentUserId, @PathVariable Long subscribedUserId) throws Exception {
        blogService.unSubscribeFromAuthor(currentUserId, subscribedUserId);
        return ResponseEntity.ok("subscribeToAuthor");
    }

    @GetMapping("/blog/users/create")
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
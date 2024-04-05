package com.example.blog.service;

import com.example.blog.faker.SeedService;
import com.example.blog.model.Article;
import com.example.blog.model.Notification;
import com.example.blog.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class BlogServiceImpl {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private NotificationService notificationService;

    public void publishArticle() throws Exception {
        log.info("\n \t\t PUBLICARE ARTICOL --------------------");
        User currentUser = SeedService.randomUserFrom(userService.listUsers());
        Article article = articleService.save(SeedService.article(currentUser.getId()));
        notificationService.sendNotification(Notification.builder()
                .message("Articol [" + article.getId() + "] publicat de [" + currentUser.getUserName() + "] .")
                .timestamp(LocalDateTime.now())
                .service("Blog service")
                .build());
    }

    public void registerUser() throws Exception {
        log.info("\n \t\t INREGISTRARE UTILIZATOR NOU --------------------");
        User currentUser = userService.save(SeedService.randomUser());
        notificationService.sendNotification(Notification.builder()
                .message("User ID[" + currentUser.getId() + "], Username[" + currentUser.getUserName() + "] creat cu success.")
                .timestamp(LocalDateTime.now())
                .service("Blog service")
                .build());
    }

}

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
        userService.listUsers().forEach(user -> {
            if(user.getSubscribedAuthors().contains(currentUser.getId())) {
                try {
                    notificationService.sendNotification(Notification.builder()
                            .message("Catre utilizatorul [" + user.getUserName() + "]\n. Autorul ["+ currentUser.getUserName()+"] a postat un articol nou: "+ article.getTitle())
                            .timestamp(LocalDateTime.now())
                            .service("Blog service")
                            .build());
                } catch (Exception e) {
                    log.error("Error while sending notification", e);
                }
            }
        });
        notificationService.sendNotification(Notification.builder()
                .message(String.format("Utilizatorii abonati la %s au fost notificati", currentUser.getUserName()))
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

    public void subscribeToAuthor() throws Exception {
        log.info("\n \t\t ABONARE LA AUTOR --------------------");
        User currentUser = SeedService.randomUserFrom(userService.listUsers());
        User author = SeedService.randomUserFrom(userService.listUsers());
        currentUser.getSubscribedAuthors().add(author.getId());
        userService.save(currentUser);

        notificationService.sendNotification(Notification.builder()
                .message("Utilizatorul [" + currentUser.getUserName() + "], s-a abonat la[" + author.getUserName() + "]")
                .timestamp(LocalDateTime.now())
                .service("Blog service")
                .build());
    }


}

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

    public String publishArticle(Long userId) throws Exception {
        System.out.println("\n \t\t -------------------- PUBLICARE ARTICOL --------------------");
        User currentUser = userService.listUsers().stream().filter(user -> user.getId() == userId).findFirst()
                .orElseThrow(() -> new Exception("User not found"));
        Article article = articleService.save(SeedService.article(currentUser.getId()));
        String res = "Autorul [" + currentUser.getUserName() + "] a postat un articol nou: " + article.getTitle();
//        System.out.println(res);
        currentUser.getSubscribedUsers().forEach(userSubId -> {
            String userName = userService.findUserById(userSubId).getUserName();
            try {
                notificationService.sendNotification(Notification.builder()
                        .message("Catre utilizatorul [" + userName + "]\n. " + res)
                        .timestamp(LocalDateTime.now())
                        .service("Blog service")
                        .build());
            } catch (Exception e) {
                log.error("Error while sending notification", e);
            }
        });

        notificationService.sendNotification(Notification.builder()
                .message(String.format("Catre [%s] : Utilizatorii abonati au fost notificati. ",
                        currentUser.getUserName()))
                .timestamp(LocalDateTime.now())
                .service("Blog service")
                .build());
        return res;
    }

    public void registerUser() throws Exception {
        System.out.println("\n \t -------------------- INREGISTRARE UTILIZATOR NOU --------------------");
        User currentUser = userService.save(SeedService.randomUser());
        String resMessage = "Username[" + currentUser.getUserName() + "] creat cu success in cadrul blogului.";
//        System.out.println(resMessage);
        // TODO: further implementation: activate notifications based on spring property
        notificationService.sendNotification(Notification.builder()
                .message("Autor nou  ID[" + currentUser.getId() + "], " + resMessage)
                .timestamp(LocalDateTime.now())
                .service("Blog service")
                .build());
    }

    public String subscribeToAuthor(Long currentUserId, Long subscribedUserId) throws Exception {
        System.out.println("\n \t --------------------  ABONARE LA BLOG  --------------------");

        User currentUser = userService.listUsers().stream().filter(user -> user.getId() == currentUserId).findFirst()
                .orElseThrow(() -> new Exception("User not found"));
        User author = userService.listUsers().stream().filter(user -> user.getId() == subscribedUserId).findFirst()
                .orElseThrow(() -> new Exception("User not found"));

        author.getSubscribedUsers().add(currentUser.getId());
        userService.save(author);
        String resMessage = String.format("Utilizatorul [" + currentUser.getUserName() + "], s-a abonat la [" + author.getUserName() + "]");
//        System.out.println(resMessage);
        notificationService.sendNotification(Notification.builder()
                .message(resMessage)
                .timestamp(LocalDateTime.now())
                .service("Blog service")
                .build());
        return resMessage;
    }

    public void unSubscribeFromAuthor(Long currentUserId, Long subscribedUserId) throws Exception {
        System.out.println("\n \t -------------------- DEZABONARE --------------------");

        User currentUser = userService.listUsers().stream().filter(user -> user.getId() == currentUserId)
                .findFirst()
                .orElseThrow(() -> new Exception("User not found"));
        User author = userService.listUsers().stream().filter(user -> user.getId() == subscribedUserId)
                .findFirst()
                .orElseThrow(() -> new Exception("User not found"));

        author.getSubscribedUsers().remove(currentUser.getId());
        userService.save(author);
        String message = "Utilizatorul [" + currentUser.getUserName() + "], s-a dezabonat de la [" + author.getUserName() + "]";
//        System.out.println(message);
        notificationService.sendNotification(Notification.builder()
                .message("Utilizatorul [" + currentUser.getUserName() + "], s-a dezabonat de la [" + author.getUserName() + "]")
                .timestamp(LocalDateTime.now())
                .service("Blog service")
                .build());
        notificationService.sendNotification(Notification.builder()
                .message("Utilizatorul [" + currentUser.getUserName() + "], s-a dezabonat de la blogul tau.")
                .timestamp(LocalDateTime.now())
                .service("Blog service")
                .build());
    }


}

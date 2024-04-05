package com.example.blog.service.impl;

import com.example.blog.faker.SeedService;
import com.example.blog.model.Article;
import com.example.blog.model.Notification;
import com.example.blog.model.User;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.NotificationService;
import com.example.blog.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final NotificationService notificationService;

    public UserServiceImpl(final UserRepository userRepository, ArticleRepository articleRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.notificationService = notificationService;
    }

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public void test() throws Exception {
        Article art = SeedService.article(listUsers());
        art = articleRepository.save(art);
        notificationService.sendNotification(Notification.builder()
                .message("Articol [" + art.getId() + "] publicat de [" + listUsers().get(0).getUserName() + "] .")
                .timestamp(LocalDateTime.now())
                .service("Article service")
                .build());
    }
}

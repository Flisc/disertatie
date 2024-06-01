package org.example.articleservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.blog.userservice.model.User;
import org.blog.userservice.service.UserService;
import org.example.articleservice.faker.SeedService;
import org.example.articleservice.model.Article;
import org.example.articleservice.model.Notification;
import org.example.articleservice.repository.ArticleRepository;
import org.example.articleservice.service.ArticleService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserService userService;
    private final String NOTIFICATION_API = "http://localhost:3000/notifications";

    public ArticleServiceImpl(ArticleRepository articleRepository, UserService userService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    @Override
    public Article save(final Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> listArticles() {
        return articleRepository.findAll();
    }

    @Override
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @Override
    public void publishArticle(final Long userId) {
        log.info("\n \t\t -----------------PUBLICARE ARTICOL [SERVICIU_ARTICOLE]--------------------");
        Article article = articleRepository.save(SeedService.article(userId));
//        User author = userService.findUserById(userId);
        String reqURL = new StringBuilder()
                .append(NOTIFICATION_API)
                .append("/newArticle/")
                .append(article.getId())
                .append("/user/")
                .append(userId)
                .toString();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqURL))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            ObjectMapper objectMapper = new ObjectMapper();
            Notification notification = objectMapper.readValue(responseBody, Notification.class);

            System.out.println("Notification message: " + notification.getMessage());

        } catch (IOException | InterruptedException e) {
            System.out.println("Error parsing notification");
            e.printStackTrace();
        }
        // TODO: notify users in user service
        // TODO: call notification  service.
    }

}

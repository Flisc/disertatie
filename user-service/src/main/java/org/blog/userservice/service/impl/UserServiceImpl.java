package org.blog.userservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.blog.userservice.model.Notification;
import org.blog.userservice.model.User;
import org.blog.userservice.repository.UserRepository;
import org.blog.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl  implements UserService {
    private final UserRepository userRepository;
    private final String NOTIFICATION_API = "http://notifications:3000/notifications";
//    private final String NOTIFICATION_API = "http://localhost:3000/notifications";

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public String subscribeTo(Long currentUserId, Long subscribedUserId) {
        Optional<User> currentUser = userRepository.findById(currentUserId);
        Optional<User> subscribedUser = userRepository.findById(subscribedUserId);
        if (currentUserId == subscribedUserId) {
            return "Utilizatorii trebuie sa fie diferiti !";
        }
        if (currentUser.isEmpty()) {
            return "Utilizatorul curent nu poate fi gasit";
        }
        if (subscribedUser.isEmpty()) {
            return "Utilizatorul tinta nu poate fi gasit";
        }

        subscribedUser.get().getSubscribedUsers().add(currentUserId);
        userRepository.save(subscribedUser.get());

        String reqURL = new StringBuilder()
                .append(NOTIFICATION_API)
                .append("/users/")
                .append(currentUserId)
                .append("/subscribe/")
                .append(subscribedUserId)
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

        return String.format("Utilizatorul %s s-a abonat la blogul utilizatorului %s",
                currentUser.get().getUserName(),
                subscribedUser.get().getUserName());
    }

    @Override
    public String unSubscribeFromAuthor(Long currentUserId, Long subscribedUserId) {
        Optional<User> currentUser = userRepository.findById(currentUserId);
        Optional<User> subscribedUser = userRepository.findById(subscribedUserId);
        if (currentUserId == subscribedUserId) {
            return "Utilizatorii trebuie sa fie diferiti !";
        }
        if (currentUser.isEmpty()) {
            return "Utilizatorul curent nu poate fi gasit";
        }
        if (subscribedUser.isEmpty()) {
            return "Utilizatorul tinta nu poate fi gasit";
        }

        subscribedUser.get().getSubscribedUsers().remove(currentUserId);
        userRepository.save(subscribedUser.get());

        String reqURL = new StringBuilder()
                .append(NOTIFICATION_API)
                .append("/users/")
                .append(currentUserId)
                .append("/unSubscribe/")
                .append(subscribedUserId)
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

        return String.format("Utilizatorul %s s-a abonat la blogul utilizatorului %s",
                currentUser.get().getUserName(),
                subscribedUser.get().getUserName());
    }
}

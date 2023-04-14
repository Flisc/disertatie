package com.pi.userpersistence.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pi.userpersistence.exceptions.InvalidMessageException;
import com.pi.userpersistence.model.Notification;
import com.pi.userpersistence.model.User;
import com.pi.userpersistence.service.NotificationService;
import com.pi.userpersistence.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@AllArgsConstructor
public class ArticlePublishedListener {
    private final ObjectMapper objectMapper;

    private final UserService userService;

    private final NotificationService notificationService;

    @KafkaListener(topics = "articles.published")
    public String listens(final String in) {
        log.info("Received Article: {}", in);
        try {
            final Map<String, Object> payload = readJsonAsMap(in);

            final User user = userFromPayload(payload);
            final User persistedUser = userService.save(user);

            final String message = String.format(
                    "User '%s' [%d] persisted!",
                    persistedUser.getUserName(),
                    persistedUser.getId()
            );
            notificationService.publishNotification(
                    Notification.builder()
                            .message(message)
                            .timestamp(LocalDateTime.now())
                            .service("user-persistence")
                            .build());

        } catch(final InvalidMessageException ex) {
            log.error("Invalid message received: {}", in);
        }
        return in;
    }

    private Map<String, Object> readJsonAsMap(final String json) {
        try{
            final TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};
            return objectMapper.readValue(json, typeRef);
        } catch(JsonProcessingException ex) {
            throw new InvalidMessageException();
        }
    }

    /**
     * Note - There are MUCH MUCH MUCH better ways of doing this.
     * 	      Implemented in this way for brevity.
     */
    private User userFromPayload(final Map<String, Object> payload) {
        final Map<String, Object> authorMap = (HashMap<String, Object>) payload.get("user");
        return User.builder()
                .id(((Integer)authorMap.get("id")).longValue())
                .userName(authorMap.get("userName").toString())
                .email(authorMap.get("email").toString())
                .age((Integer)authorMap.get("age"))
                .build();
    }

}

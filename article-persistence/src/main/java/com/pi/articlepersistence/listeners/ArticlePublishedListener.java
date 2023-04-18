package com.pi.articlepersistence.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pi.articlepersistence.exceptions.InvalidMessageException;
import com.pi.articlepersistence.models.Article;
import com.pi.articlepersistence.models.Notification;
import com.pi.articlepersistence.services.ArticleService;
import com.pi.articlepersistence.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@AllArgsConstructor
public class ArticlePublishedListener {
    private final ObjectMapper objectMapper;
    private final NotificationService notificationService;
    private final ArticleService articleService;
    // TODO Flisc 15.04.2023 uncomment after publisher it's ready
   //    @KafkaListener(topics = "articles.published")
    public String listens(final String input) {
        log.info("Received Article: {}", input);
        try {
            final Map<String, Object> payload = readJsonAsMap(input);

            final Article article = articleFromPayload(payload);
            final Article savedArticle = articleService.save(article);

            final String message = String.format(
                    "Article '%s' [%s] persisted!",
                    savedArticle.getTitle(),
                    savedArticle.getId()
            );
            notificationService.publishNotification(
                    Notification.builder()
                            .message(message)
                            .timestamp(LocalDateTime.now())
                            .service("book-persistence")
                            .build());

        } catch (final InvalidMessageException ex) {
            log.error("Invalid message received: {}", input);
        }

        return input;
    }

    private Map<String, Object> readJsonAsMap(final String json) {
        try {
            final TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            return objectMapper.readValue(json, typeRef);
        } catch (JsonProcessingException ex) {
            throw new InvalidMessageException();
        }
    }

    /**
     * Note - There are MUCH MUCH MUCH better ways of doing this.
     * Implemented in this way for brevity.
     */
    private Article articleFromPayload(final Map<String, Object> payload) {
        final Integer authorId = (Integer) ((HashMap<String, Object>) payload.get("author")).get("id"); /* <- Don't do this in prod!!! :| */
        return Article.builder()
                .id(Long.valueOf(payload.get("id").toString()))
                .title(payload.get("title").toString())
                .body(payload.get("body").toString())
                .author(authorId.longValue())
                .build();
    }
}

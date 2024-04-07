package pi.notifications.notifications.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pi.notifications.notifications.models.Notification;
import pi.notifications.notifications.services.NotificationsService;

@Component
//@Profile("production")
@Slf4j
@AllArgsConstructor
public class NotificationListener {
    private final ObjectMapper objectMapper;

    private final NotificationsService notificationService;

    @KafkaListener(topics = "notification.created")
    public String listens(final String payload) {
        log.info("\n Received Notification: {}", payload);
        try {
            final Notification notification = objectMapper.readValue(payload, Notification.class);

            final Notification savedNotification = notificationService.save(notification);

            log.info("Notification '{}' persisted!", savedNotification.getTimestamp().toString());

        } catch (final JsonProcessingException ex) {
            log.error("Invalid message received: {}", payload);
        }
        return payload;
    }
}

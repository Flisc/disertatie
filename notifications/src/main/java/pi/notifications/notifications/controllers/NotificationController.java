package pi.notifications.notifications.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pi.notifications.notifications.models.Notification;
import pi.notifications.notifications.services.NotificationsService;

import java.util.List;

@RestController
public class NotificationController {

    public NotificationController(final NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    private final NotificationsService notificationsService;

    @GetMapping(path="/notifications")
    public List<Notification> listNotifications() {
        return notificationsService.listNotifications();
    }

}

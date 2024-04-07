package pi.notifications.notifications.services;

import pi.notifications.notifications.models.Notification;

import java.util.List;

public interface NotificationsService {
    Notification save(Notification notification);

    List<Notification> listNotifications();
}

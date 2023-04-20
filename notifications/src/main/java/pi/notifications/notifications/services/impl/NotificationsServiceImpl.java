package pi.notifications.notifications.services.impl;

import org.springframework.stereotype.Service;
import pi.notifications.notifications.models.Notification;
import pi.notifications.notifications.repositories.NotificationRepository;
import pi.notifications.notifications.services.NotificationsService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NotificationsServiceImpl implements NotificationsService {

    private final NotificationRepository notificationRepository;

    public NotificationsServiceImpl(final NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification save(final Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> listNotifications() {
        return StreamSupport
                .stream(notificationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}

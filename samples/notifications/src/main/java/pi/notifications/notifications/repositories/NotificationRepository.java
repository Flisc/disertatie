package pi.notifications.notifications.repositories;

import org.springframework.data.repository.CrudRepository;
import pi.notifications.notifications.models.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

}

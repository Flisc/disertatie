package pi.article.publisher.articlepublisher.repositories;

import org.springframework.data.repository.CrudRepository;
import pi.article.publisher.articlepublisher.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
}

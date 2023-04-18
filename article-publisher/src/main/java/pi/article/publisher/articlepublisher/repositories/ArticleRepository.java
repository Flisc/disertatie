package pi.article.publisher.articlepublisher.repositories;

import org.springframework.data.repository.CrudRepository;
import pi.article.publisher.articlepublisher.models.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
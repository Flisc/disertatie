package pi.article.publisher.articlepublisher.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pi.article.publisher.articlepublisher.config.KafkaConfigProps;
import pi.article.publisher.articlepublisher.exceptions.ArticlePublishException;
import pi.article.publisher.articlepublisher.models.Article;

@Service
@AllArgsConstructor
public class KafkaArticlePublisherService implements ArticlePublisherService {

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaConfigProps kafkaConfigProps;

    @Override
    public void publish(final Article article) {
        try {
            final String payload = objectMapper.writeValueAsString(article);
            kafkaTemplate.send(kafkaConfigProps.getTopic(), payload);
        } catch (final JsonProcessingException ex) {
            throw new ArticlePublishException("Unable to publish article", ex, article);
        }
    }
}

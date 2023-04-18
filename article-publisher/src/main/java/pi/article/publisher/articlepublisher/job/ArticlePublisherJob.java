package pi.article.publisher.articlepublisher.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pi.article.publisher.articlepublisher.repositories.ArticleRepository;
import pi.article.publisher.articlepublisher.services.ArticlePublisherService;

@Component
@Slf4j
public class ArticlePublisherJob {
    private long counter;
    private final ArticleRepository articleRepository;
    private final ArticlePublisherService articlePublisherService;

    public ArticlePublisherJob(final ArticleRepository articleRepository, final ArticlePublisherService articlePublisherService) {
        resetCounter();
        this.articleRepository = articleRepository;
        this.articlePublisherService = articlePublisherService;
    }

    @Scheduled(cron = "0/20 * * * * *")
    public void publishBook() {
        articleRepository.findById(counter).ifPresentOrElse(article -> {
            counter += 1;
            articlePublisherService.publish(article);
            log.info("Article '{}' [{}] published.", article.getTitle(), article.getId());
        }, () -> resetCounter());
    }

    private void resetCounter() {
        this.counter = 1;
    }

}

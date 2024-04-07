package pi.article.publisher.articlepublisher.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pi.article.publisher.articlepublisher.repositories.ArticleRepository;
import pi.article.publisher.articlepublisher.services.ArticlePublisherService;

@Component
@Slf4j
public class ArticlePublisherJob {
    private Long counter;
    private final ArticleRepository articleRepository;
    private final ArticlePublisherService articlePublisherService;


    @Autowired
    public ArticlePublisherJob(final ArticleRepository articleRepository, final ArticlePublisherService articlePublisherService) {
        resetCounter();
        this.articleRepository = articleRepository;
        this.articlePublisherService = articlePublisherService;
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void publishArticle() {
        articleRepository.findById(counter).ifPresentOrElse(article -> {
            counter += 1L;
            articlePublisherService.publish(article);
            log.info("Article '{}' [{}] published.", article.getTitle(), article.getId());
        }, () -> resetCounter());
    }

    private void resetCounter() {
        this.counter = 1L;
    }

}

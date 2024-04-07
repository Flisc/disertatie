package pi.article.publisher.articlepublisher.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import pi.article.publisher.articlepublisher.models.Article;

@Data
@AllArgsConstructor
public class ArticlePublishException extends RuntimeException {

    private Article article;

    public ArticlePublishException(String message, final Article article) {
        super(message);
        this.article = article;
    }

    public ArticlePublishException(Throwable cause, final Article article) {
        super(cause);
        this.article = article;
    }

    public ArticlePublishException(String message, Throwable cause, final Article article) {
        super(message, cause);
        this.article = article;
    }

    public ArticlePublishException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace, final Article article) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.article = article;
    }

}

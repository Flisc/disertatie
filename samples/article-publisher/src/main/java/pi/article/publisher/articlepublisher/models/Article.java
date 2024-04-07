package pi.article.publisher.articlepublisher.models;

import jakarta.persistence.*;
import lombok.*;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;

//    @ManyToOne
//    @JoinColumn(name="author_id")
    private Long author_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Article() {
//    }
//
//    public Article(Long id, String title, String body, Long author_id) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//        this.author_id = author_id;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Long getAuthor_id() {
        return author_id;
    }
}

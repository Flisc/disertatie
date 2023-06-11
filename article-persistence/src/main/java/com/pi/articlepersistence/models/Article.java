package com.pi.articlepersistence.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;
    private Long author;

    @Builder
    public Article(Long id, String title, String body, Long author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}

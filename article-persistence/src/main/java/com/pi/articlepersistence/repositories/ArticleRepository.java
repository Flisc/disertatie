package com.pi.articlepersistence.repositories;

import com.pi.articlepersistence.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, String> {
}

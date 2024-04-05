package com.example.blog.repository;

import com.example.blog.model.Article;
import com.example.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {

}

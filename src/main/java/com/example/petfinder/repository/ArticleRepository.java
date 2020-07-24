package com.example.petfinder.repository;

import com.example.petfinder.model.article.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}

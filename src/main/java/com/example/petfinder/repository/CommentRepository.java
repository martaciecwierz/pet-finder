package com.example.petfinder.repository;

import com.example.petfinder.model.article.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}

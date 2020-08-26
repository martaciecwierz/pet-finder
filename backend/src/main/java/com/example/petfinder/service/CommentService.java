package com.example.petfinder.service;

import com.example.petfinder.dto.article.CommentDto;
import com.example.petfinder.error.exception.notFound.ArticleNotFoundException;
import com.example.petfinder.error.exception.notFound.CommentNotFoundException;
import com.example.petfinder.error.exception.notFound.UserNotFoundException;
import com.example.petfinder.model.article.Article;
import com.example.petfinder.model.article.Comment;
import com.example.petfinder.model.user.User;
import com.example.petfinder.repository.ArticleRepository;
import com.example.petfinder.repository.CommentRepository;
import com.example.petfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
public class CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private ArticleRepository articleRepository;
    private ModelMapper modelMapper;

    public CommentService(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    public CommentDto findCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
        return modelMapper.map(comment, CommentDto.class);
    }

    @Transactional
    public CommentDto addComment(Long userId, Long articleId, Date date, String content) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));
        Comment comment = Comment.builder().user(user).article(article).date(date).content(content).build();
        return modelMapper.map(commentRepository.save(comment), CommentDto.class);
    }
}

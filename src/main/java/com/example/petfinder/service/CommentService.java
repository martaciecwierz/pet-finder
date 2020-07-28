package com.example.petfinder.service;

import com.example.petfinder.dto.article.CommentDto;
import com.example.petfinder.error.exception.notFound.CommentNotFoundException;
import com.example.petfinder.model.article.Comment;
import com.example.petfinder.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CommentService {

    private CommentRepository commentRepository;
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
}

package com.example.petfinder.service;

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
}

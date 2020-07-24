package com.example.petfinder.service;

import com.example.petfinder.repository.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ArticleService {

    private ArticleRepository articleRepository;
    private ModelMapper modelMapper;

    public ArticleService(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }
}

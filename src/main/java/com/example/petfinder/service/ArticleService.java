package com.example.petfinder.service;

import com.example.petfinder.dto.article.ArticleDto;
import com.example.petfinder.error.exception.notFound.ArticleNotFoundException;
import com.example.petfinder.model.article.Article;
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

    public ArticleDto findArticleById(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));
        return modelMapper.map(article, ArticleDto.class);
    }
}

package com.example.petfinder.service;

import com.example.petfinder.dto.article.ArticleDto;
import com.example.petfinder.error.exception.notFound.ArticleNotFoundException;
import com.example.petfinder.error.exception.notFound.ShelterNotFoundException;
import com.example.petfinder.model.article.Article;
import com.example.petfinder.model.shelter.Shelter;
import com.example.petfinder.repository.ArticleRepository;
import com.example.petfinder.repository.ShelterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
public class ArticleService {

    private ArticleRepository articleRepository;
    private ShelterRepository shelterRepository;
    private ModelMapper modelMapper;

    public ArticleService(ArticleRepository articleRepository, ShelterRepository shelterRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.shelterRepository = shelterRepository;
        this.modelMapper = modelMapper;
    }

    public ArticleDto findArticleById(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));
        return modelMapper.map(article, ArticleDto.class);
    }

    @Transactional
    public ArticleDto addArticle(Long shelterId, Date date, String title, String content, String image) {
        Shelter shelter = shelterRepository.findById(shelterId)
                .orElseThrow(() -> new ShelterNotFoundException(shelterId));
        Article article = Article.builder()
                .shelter(shelter)
                .date(date)
                .title(title)
                .content(content)
                .image(image)
                .build();
        return modelMapper.map(articleRepository.save(article), ArticleDto.class);
    }
}

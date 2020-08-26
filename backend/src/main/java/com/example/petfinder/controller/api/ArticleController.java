package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddArticleRequest;
import com.example.petfinder.dto.article.ArticleDto;
import com.example.petfinder.service.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("article/{id}")
    public ArticleDto findById(@PathVariable Long id) {
        return articleService.findArticleById(id);
    }

    @PostMapping("article")
    public ArticleDto addArticle(@RequestBody AddArticleRequest addArticleRequest) {
        return articleService.addArticle(
                addArticleRequest.getShelterId(),
                addArticleRequest.getDate(),
                addArticleRequest.getTitle(),
                addArticleRequest.getContent(),
                addArticleRequest.getImage()
        );
    }
}

package com.example.petfinder.dto.article;

import com.example.petfinder.dto.article.ArticleDto;
import com.example.petfinder.dto.user.UserDto;
import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {

    private Long id;
    private UserDto userDto;
    private ArticleDto articleDto;
    private Date date;
    private String content;
}

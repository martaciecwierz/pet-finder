package com.example.petfinder.dto.article;

import com.example.petfinder.dto.shelter.ShelterDto;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleDto {

    private Long id;
    private ShelterDto shelterDto;
    private Date date;
    private String title;
    private String content;
    private String image;
}

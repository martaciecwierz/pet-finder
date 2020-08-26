package com.example.petfinder.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddArticleRequest {

    private Long shelterId;
    private Date date;
    private String title;
    private String content;
    private String image;
}

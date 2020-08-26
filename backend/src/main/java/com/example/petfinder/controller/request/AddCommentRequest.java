package com.example.petfinder.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddCommentRequest {

    private Long userId;
    private Long articleId;
    private Date date;
    private String content;
}

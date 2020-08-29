package com.example.petfinder.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAttributeRequest {

    private Long id;
    private String name;
    private String type;
}

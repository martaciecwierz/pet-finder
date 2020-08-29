package com.example.petfinder.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AttributeResponse {

    private Long id;
    private String name;
    private String type;
}

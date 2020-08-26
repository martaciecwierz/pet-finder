package com.example.petfinder.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAnimalAttributeRequest {

    private Long animalId;
    private Long attributeId;
    private String value;
}

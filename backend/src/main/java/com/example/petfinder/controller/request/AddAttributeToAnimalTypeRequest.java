package com.example.petfinder.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAttributeToAnimalTypeRequest {

    private Long attributeId;
    private Long animalTypeId;
}

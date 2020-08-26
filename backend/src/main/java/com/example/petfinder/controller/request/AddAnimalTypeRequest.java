package com.example.petfinder.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AddAnimalTypeRequest {

    private String name;
    private Set<Long> attributesIds;


}

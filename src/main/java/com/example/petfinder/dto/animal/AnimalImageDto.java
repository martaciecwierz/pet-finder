package com.example.petfinder.dto.animal;

import com.example.petfinder.dto.animal.AnimalDto;
import lombok.Data;

@Data
public class AnimalImageDto {

    private Long id;
    private AnimalDto animalDto;
    private String image;
}

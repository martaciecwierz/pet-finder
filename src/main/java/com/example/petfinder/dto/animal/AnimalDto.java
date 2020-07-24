package com.example.petfinder.dto.animal;

import com.example.petfinder.dto.shelter.ShelterDto;
import lombok.Data;

@Data
public class AnimalDto {

    private Long id;
    private ShelterDto shelterDto;
    private AnimalTypeDto animalTypeDto;
    private String name;
    private String description;
}

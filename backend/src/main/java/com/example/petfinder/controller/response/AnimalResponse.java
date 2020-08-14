package com.example.petfinder.controller.response;

import com.example.petfinder.dto.animal.AnimalDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalResponse {

    private Long id;
    private String name;
    private String description;
    private Long typeId;
    private Long shelterId;

    public static AnimalResponse mapFromAnimalDto(AnimalDto animalDto){
        AnimalResponse animalResponse = new AnimalResponse();
        animalResponse.id = animalDto.getId();
        animalResponse.name = animalDto.getName();
        animalResponse.description = animalDto.getDescription();
        animalResponse.typeId = animalDto.getAnimalTypeDto().getId();
        animalResponse.shelterId = animalDto.getShelterDto().getId();
        return animalResponse;
    }
}

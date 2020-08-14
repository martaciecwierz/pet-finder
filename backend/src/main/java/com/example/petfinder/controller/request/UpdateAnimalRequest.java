package com.example.petfinder.controller.request;

import com.example.petfinder.dto.animal.AnimalDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAnimalRequest {

    private Long id;
    private String name;
    private String description;

    public AnimalDto mapToAnimalDto(){
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(id);
        animalDto.setName(name);
        animalDto.setDescription(description);
        return animalDto;
    }
}

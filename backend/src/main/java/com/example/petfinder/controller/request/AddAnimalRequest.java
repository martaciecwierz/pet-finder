package com.example.petfinder.controller.request;

import com.example.petfinder.dto.animal.AnimalDto;
import com.example.petfinder.dto.animal.AnimalTypeDto;
import com.example.petfinder.dto.shelter.ShelterDto;
import com.example.petfinder.error.exception.notFound.AnimalTypeNotFoundException;
import com.example.petfinder.error.exception.notFound.ShelterNotFoundException;
import com.example.petfinder.model.animal.AnimalType;
import com.example.petfinder.model.shelter.Shelter;
import com.example.petfinder.repository.AnimalTypeRepository;
import com.example.petfinder.repository.ShelterRepository;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class AddAnimalRequest {

    private String name;
    private Long shelterId;
    private Long typeId;
    private String description;

    public AnimalDto mapToAnimalDto(ShelterRepository shelterRepository,
                                    AnimalTypeRepository animalTypeRepository,
                                    ModelMapper modelMapper){
        Shelter shelter = shelterRepository.findById(shelterId)
                .orElseThrow(() -> new ShelterNotFoundException(shelterId));
        AnimalType animalType = animalTypeRepository.findById(typeId)
                .orElseThrow(() -> new AnimalTypeNotFoundException(typeId));
        ShelterDto shelterDto = modelMapper.map(shelter, ShelterDto.class);
        AnimalTypeDto animalTypeDto = modelMapper.map(animalType, AnimalTypeDto.class);
        AnimalDto animalDto = new AnimalDto();
        animalDto.setName(name);
        animalDto.setShelterDto(shelterDto);
        animalDto.setAnimalTypeDto(animalTypeDto);
        animalDto.setDescription(description);
        return animalDto;
    }

}

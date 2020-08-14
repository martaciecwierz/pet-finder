package com.example.petfinder.service;

import com.example.petfinder.controller.request.AddAnimalRequest;
import com.example.petfinder.dto.animal.AnimalDto;
import com.example.petfinder.dto.animal.AnimalTypeDto;
import com.example.petfinder.dto.shelter.ShelterDto;
import com.example.petfinder.error.exception.notFound.AnimalNotFoundException;
import com.example.petfinder.error.exception.notFound.AnimalTypeNotFoundException;
import com.example.petfinder.error.exception.notFound.ShelterNotFoundException;
import com.example.petfinder.model.animal.Animal;
import com.example.petfinder.model.animal.AnimalType;
import com.example.petfinder.model.shelter.Shelter;
import com.example.petfinder.repository.AnimalRepository;
import com.example.petfinder.repository.AnimalTypeRepository;
import com.example.petfinder.repository.ShelterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AnimalService {

    private AnimalRepository animalRepository;
    private ModelMapper modelMapper;
    private ShelterRepository shelterRepository;
    private AnimalTypeRepository animalTypeRepository;

    public AnimalService(AnimalRepository animalRepository,
                         ModelMapper modelMapper,
                         ShelterRepository shelterRepository,
                         AnimalTypeRepository animalTypeRepository) {
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
        this.shelterRepository = shelterRepository;
        this.animalTypeRepository = animalTypeRepository;
    }

    @Transactional
    public void addNewAnimal(AddAnimalRequest addAnimalRequest) {
        AnimalDto animalDto = addAnimalRequest.mapToAnimalDto(shelterRepository, animalTypeRepository, modelMapper);
        Animal animal = modelMapper.map(animalDto, Animal.class);
        animalRepository.save(animal);
    }

    @Transactional
    public AnimalDto updateAnimalProfile(AnimalDto animalDto) {
        AnimalDto dto = findAnimalById(animalDto.getId());
        dto.setName(animalDto.getName());
        dto.setDescription(animalDto.getDescription());
        return dto;
    }

    public List<AnimalDto> findByAnimalType(Long animalTypeId) {
        AnimalType animalType = animalTypeRepository.findById(animalTypeId)
                .orElseThrow(() -> new AnimalTypeNotFoundException(animalTypeId));
        List<Animal> animals = animalRepository.findByAnimalType(animalType);
        return animals.stream()
                .map(animal -> modelMapper.map(animal, AnimalDto.class))
                .collect(Collectors.toList());
    }

    public List<AnimalDto> findByShelter(Long shelterId) {
        Shelter shelter = shelterRepository.findById(shelterId)
                .orElseThrow(() -> new ShelterNotFoundException(shelterId));
        List<Animal> animals = animalRepository.findByShelter(shelter);
        return animals.stream()
                .map(animal -> modelMapper.map(animal, AnimalDto.class))
                .collect(Collectors.toList());
    }

    public AnimalDto findAnimalById(Long animalId) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new AnimalNotFoundException(animalId));
        return modelMapper.map(animal, AnimalDto.class);

    }
}

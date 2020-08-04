package com.example.petfinder.service;

import com.example.petfinder.dto.animal.AnimalDto;
import com.example.petfinder.dto.animal.AnimalTypeDto;
import com.example.petfinder.dto.shelter.ShelterDto;
import com.example.petfinder.error.exception.notFound.AnimalNotFoundException;
import com.example.petfinder.model.animal.Animal;
import com.example.petfinder.model.animal.AnimalType;
import com.example.petfinder.model.shelter.Shelter;
import com.example.petfinder.repository.AnimalRepository;
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

    public AnimalService(AnimalRepository animalRepository, ModelMapper modelMapper) {
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void addNewAnimal(AnimalDto animalDto) {
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

    public List<AnimalDto> findByAnimalType(AnimalTypeDto animalTypeDto) {
        AnimalType animalType = modelMapper.map(animalTypeDto, AnimalType.class);
        List<Animal> animals = animalRepository.findByAnimalType(animalType);
        return animals.stream()
                .map(animal -> modelMapper.map(animal, AnimalDto.class))
                .collect(Collectors.toList());
    }

    public List<AnimalDto> findByShelter(ShelterDto shelterDto) {
        Shelter shelter = modelMapper.map(shelterDto, Shelter.class);
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

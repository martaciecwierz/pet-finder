package com.example.petfinder.service;

import com.example.petfinder.dto.animal.AnimalDto;
import com.example.petfinder.error.exception.notFound.AnimalNotFoundException;
import com.example.petfinder.model.animal.Animal;
import com.example.petfinder.repository.AnimalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AnimalService {

    private AnimalRepository animalRepository;
    private ModelMapper modelMapper;

    public AnimalService(AnimalRepository animalRepository, ModelMapper modelMapper) {
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
    }

    public AnimalDto findAnimalById(Long animalId) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new AnimalNotFoundException(animalId));
        return modelMapper.map(animal, AnimalDto.class);

    }
}

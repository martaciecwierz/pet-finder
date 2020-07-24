package com.example.petfinder.service;

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
}

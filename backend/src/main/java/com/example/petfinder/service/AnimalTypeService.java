package com.example.petfinder.service;

import com.example.petfinder.controller.request.AddAnimalTypeRequest;
import com.example.petfinder.dto.animal.AnimalTypeDto;
import com.example.petfinder.error.exception.notFound.AnimalTypeNotFoundException;
import com.example.petfinder.model.animal.AnimalType;
import com.example.petfinder.model.animal.Attribute;
import com.example.petfinder.repository.AnimalTypeRepository;
import com.example.petfinder.repository.AttributeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
public class AnimalTypeService {

    private AnimalTypeRepository animalTypeRepository;
    private AttributeRepository attributeRepository;
    private ModelMapper modelMapper;

    public AnimalTypeService(AnimalTypeRepository animalTypeRepository, AttributeRepository attributeRepository, ModelMapper modelMapper) {
        this.animalTypeRepository = animalTypeRepository;
        this.attributeRepository = attributeRepository;
        this.modelMapper = modelMapper;
    }

    public AnimalTypeDto findAnimalTypeById(Long id) {
        AnimalType animalType = animalTypeRepository.findById(id).orElseThrow(() -> new AnimalTypeNotFoundException(id));
        return modelMapper.map(animalType, AnimalTypeDto.class);
    }

    @Transactional
    public AnimalTypeDto addAnimalType(AddAnimalTypeRequest addAnimalTypeRequest) {
        Set<Attribute> attributes = StreamSupport
                .stream(attributeRepository.findAllById(addAnimalTypeRequest.getAttributesIds()).spliterator(), false)
                .collect(Collectors.toSet());
        AnimalType animalType = AnimalType.builder().name(addAnimalTypeRequest.getName()).attributes(attributes).build();
        return modelMapper.map(animalTypeRepository.save(animalType), AnimalTypeDto.class);
    }
}

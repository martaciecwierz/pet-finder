package com.example.petfinder.service;

import com.example.petfinder.dto.animal.AnimalAttributeDto;
import com.example.petfinder.error.exception.notFound.AnimalAttributeNotFoundException;
import com.example.petfinder.error.exception.notFound.AnimalNotFoundException;
import com.example.petfinder.error.exception.notFound.AttributeNotFoundException;
import com.example.petfinder.model.animal.Animal;
import com.example.petfinder.model.animal.AnimalAttribute;
import com.example.petfinder.model.animal.Attribute;
import com.example.petfinder.repository.AnimalAttributeRepository;
import com.example.petfinder.repository.AnimalRepository;
import com.example.petfinder.repository.AttributeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AnimalAttributeService {

    private AnimalAttributeRepository animalAttributeRepository;
    private AttributeRepository attributeRepository;
    private AnimalRepository animalRepository;
    private ModelMapper modelMapper;

    public AnimalAttributeService(AnimalAttributeRepository animalAttributeRepository,
                                  AttributeRepository attributeRepository,
                                  AnimalRepository animalRepository,
                                  ModelMapper modelMapper) {
        this.animalAttributeRepository = animalAttributeRepository;
        this.attributeRepository = attributeRepository;
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
    }

    public AnimalAttributeDto findAnimalAttributeById(Long id) {
        AnimalAttribute animalAttribute = animalAttributeRepository.findById(id)
                .orElseThrow(() -> new AnimalAttributeNotFoundException(id));
        return modelMapper.map(animalAttribute, AnimalAttributeDto.class);
    }

    @Transactional
    public AnimalAttributeDto addAnimalAttribute(Long animalId, Long attributeId, String value) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new AnimalNotFoundException(animalId));
        Attribute attribute = attributeRepository.findById(attributeId)
                .orElseThrow(() -> new AttributeNotFoundException(attributeId));
        AnimalAttribute animalAttribute = AnimalAttribute.builder()
                .animal(animal)
                .attribute(attribute)
                .value(value)
                .build();
        return modelMapper.map(animalAttributeRepository.save(animalAttribute), AnimalAttributeDto.class);
    }

}

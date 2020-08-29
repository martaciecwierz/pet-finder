package com.example.petfinder.service;

import com.example.petfinder.dto.animal.AttributeDto;
import com.example.petfinder.error.exception.notFound.AnimalTypeNotFoundException;
import com.example.petfinder.error.exception.notFound.AttributeNotFoundException;
import com.example.petfinder.model.animal.AnimalType;
import com.example.petfinder.model.animal.Attribute;
import com.example.petfinder.repository.AnimalTypeRepository;
import com.example.petfinder.repository.AttributeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
public class AttributeService {

    private AttributeRepository attributeRepository;
    private AnimalTypeRepository animalTypeRepository;
    private ModelMapper modelMapper;

    public AttributeService(AttributeRepository attributeRepository, AnimalTypeRepository animalTypeRepository, ModelMapper modelMapper) {
        this.attributeRepository = attributeRepository;
        this.animalTypeRepository = animalTypeRepository;
        this.modelMapper = modelMapper;
    }

    public AttributeDto findAttributeById(Long id) {
        Attribute attribute = attributeRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException(id));
        return modelMapper.map(attribute, AttributeDto.class);
    }

    public List<AttributeDto> findAllAttributes() {
        return StreamSupport.stream(attributeRepository.findAll().spliterator(), false)
                .map(attribute -> modelMapper.map(attribute, AttributeDto.class))
                .collect(Collectors.toList());
    }

    public List<AttributeDto> findAttributesByAnimalType(Long animalTypeId) {
        AnimalType animalType = animalTypeRepository.findById(animalTypeId)
                .orElseThrow(() -> new AnimalTypeNotFoundException(animalTypeId));
        return attributeRepository.findAllByAnimalTypes(animalType).stream()
                .map(attribute -> modelMapper.map(attribute, AttributeDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public AttributeDto addAttribute(String name, String type) {
        Attribute attribute = Attribute.builder().name(name).type(type).build();
        return modelMapper.map(attributeRepository.save(attribute), AttributeDto.class);
    }

    @Transactional
    public AttributeDto updateAttribute(Long id, String name, String type) {
        AttributeDto dto = findAttributeById(id);
        dto.setName(name);
        dto.setType(type);
        Attribute attribute = modelMapper.map(dto, Attribute.class);
        return modelMapper.map(attributeRepository.save(attribute), AttributeDto.class);
    }

    @Transactional
    public void deleteAttribute(Long attributeId) {
        Attribute attribute = attributeRepository.findById(attributeId)
                .orElseThrow(() -> new AttributeNotFoundException(attributeId));
        attributeRepository.delete(attribute);
    }

    @Transactional
    public AttributeDto addAnimalTypeToAttribute(Long animalTypeId, Long attributeId) {
        AnimalType animalType = animalTypeRepository.findById(animalTypeId)
                .orElseThrow(() -> new AnimalTypeNotFoundException(animalTypeId));
        Attribute attribute = attributeRepository.findById(attributeId)
                .orElseThrow(() -> new AttributeNotFoundException(attributeId));
        //TODO check is animalType not yet in attribute
        attribute.getAnimalTypes().add(animalType);
        return modelMapper.map(attributeRepository.save(attribute), AttributeDto.class);
    }

}

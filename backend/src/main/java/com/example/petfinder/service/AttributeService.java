package com.example.petfinder.service;

import com.example.petfinder.dto.animal.AttributeDto;
import com.example.petfinder.error.exception.notFound.AttributeNotFoundException;
import com.example.petfinder.model.animal.Attribute;
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
    private ModelMapper modelMapper;

    public AttributeService(AttributeRepository attributeRepository, ModelMapper modelMapper) {
        this.attributeRepository = attributeRepository;
        this.modelMapper = modelMapper;
    }

    public AttributeDto findAttributeById(Long id) {
        Attribute attribute = attributeRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException(id));
        return modelMapper.map(attribute, AttributeDto.class);
    }

    @Transactional
    public AttributeDto addAttribute(String name, String type) {
        Attribute attribute = Attribute.builder().name(name).type(type).build();
        return modelMapper.map(attributeRepository.save(attribute), AttributeDto.class);
    }

    @Transactional
    public AttributeDto updateAttribute(AttributeDto attributeDto) {
        AttributeDto dto = findAttributeById(attributeDto.getId());
        dto.setName(attributeDto.getName());
        dto.setType(attributeDto.getType());
        Attribute attribute = modelMapper.map(dto, Attribute.class);
        return modelMapper.map(attributeRepository.save(attribute), AttributeDto.class);
    }

    public List<AttributeDto> findAllAttributes() {
        return StreamSupport.stream(attributeRepository.findAll().spliterator(), false)
                .map(attribute -> modelMapper.map(attribute, AttributeDto.class))
                .collect(Collectors.toList());
    }
}

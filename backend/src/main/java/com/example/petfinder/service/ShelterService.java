package com.example.petfinder.service;

import com.example.petfinder.dto.shelter.ShelterDto;
import com.example.petfinder.error.exception.notFound.ShelterNotFoundException;
import com.example.petfinder.model.shelter.Shelter;
import com.example.petfinder.repository.ShelterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ShelterService {

    private ShelterRepository shelterRepository;
    private ModelMapper modelMapper;

    public ShelterService(ShelterRepository shelterRepository, ModelMapper modelMapper) {
        this.shelterRepository = shelterRepository;
        this.modelMapper = modelMapper;
    }

    public ShelterDto findShelterById(Long shelterId) {
        Shelter shelter = shelterRepository.findById(shelterId)
                .orElseThrow(() -> new ShelterNotFoundException(shelterId));
        return modelMapper.map(shelter, ShelterDto.class);
    }
}

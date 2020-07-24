package com.example.petfinder.service;

import com.example.petfinder.repository.VolunteerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VolunteerService {

    private VolunteerRepository volunteerRepository;
    private ModelMapper modelMapper;

    public VolunteerService(VolunteerRepository volunteerRepository, ModelMapper modelMapper) {
        this.volunteerRepository = volunteerRepository;
        this.modelMapper = modelMapper;
    }
}

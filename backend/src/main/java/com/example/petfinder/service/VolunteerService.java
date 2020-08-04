package com.example.petfinder.service;

import com.example.petfinder.dto.user.VolunteerDto;
import com.example.petfinder.error.exception.notFound.VolunteerNotFoundException;
import com.example.petfinder.model.user.Volunteer;
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

    public VolunteerDto findVolunteerById(Long volunteerId) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId)
                .orElseThrow(() -> new VolunteerNotFoundException(volunteerId));
        return modelMapper.map(volunteer, VolunteerDto.class);
    }
}

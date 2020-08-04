package com.example.petfinder.dto.user;

import com.example.petfinder.dto.shelter.ShelterDto;
import lombok.Data;

import java.util.Date;

@Data
public class VolunteerDto {

    private Long id;
    private ShelterDto shelterDto;
    private UserDto userDto;
    private Date start;
}

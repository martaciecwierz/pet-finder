package com.example.petfinder.dto.user;

import com.example.petfinder.dto.shelter.ShelterDto;
import lombok.Data;

@Data
public class AdminDto {

    private Long id;
    private ShelterDto shelterDto;
    private UserDto userDto;
    private int rights;
}

package com.example.petfinder.controller.response;

import com.example.petfinder.dto.shelter.ShelterDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ShelterListResponse {

    List<ShelterDto> shelters;
}

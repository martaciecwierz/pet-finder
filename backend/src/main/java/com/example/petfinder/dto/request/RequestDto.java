package com.example.petfinder.dto.request;

import com.example.petfinder.dto.shelter.ShelterDto;
import lombok.Data;

@Data
public class RequestDto {

    private Long id;
    private ShelterDto shelterDto;
    private RequestTypeDto requestTypeDto;
    private int quantity;
}

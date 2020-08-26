package com.example.petfinder.controller.request;

import com.example.petfinder.dto.shelter.ShelterDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddShelterRequest {

    private String name;
    private String addressStreet;
    private String addressBuilding;
    private String addressCity;
    private String addressPostCode;
    private String email;
    private String phone;
    private String description;

    public ShelterDto mapToDto() {
        return ShelterDto.builder()
                .name(name)
                .addressStreet(addressStreet)
                .addressBuilding(addressBuilding)
                .addressCity(addressCity)
                .addressPostCode(addressPostCode)
                .email(email)
                .phone(phone)
                .description(description)
                .build();
    }
}

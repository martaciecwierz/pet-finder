package com.example.petfinder.dto.shelter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShelterDto {

    private long id;
    private String name;
    private String addressStreet;
    private String addressBuilding;
    private String addressCity;
    private String addressPostCode;
    private String email;
    private String phone;
    private String description;
}

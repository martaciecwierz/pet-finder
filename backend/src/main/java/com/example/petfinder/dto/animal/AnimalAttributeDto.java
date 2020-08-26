package com.example.petfinder.dto.animal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalAttributeDto {

    private Long id;
    private AnimalDto animalDto;
    private AttributeDto attributeDto;
    private String value;
}

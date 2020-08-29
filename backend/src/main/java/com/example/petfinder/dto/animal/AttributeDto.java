package com.example.petfinder.dto.animal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeDto {

    private Long id;
    private String name;
    private String type;
    Set<AnimalTypeDto> animalTypes = new HashSet<>();
}

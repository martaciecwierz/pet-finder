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
public class AnimalTypeDto {

    private Long id;
    private String name;
    private Set<AttributeDto> attributes = new HashSet<>();
}

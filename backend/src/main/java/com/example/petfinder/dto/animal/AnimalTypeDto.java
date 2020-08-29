package com.example.petfinder.dto.animal;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "attributes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalTypeDto {

    private Long id;
    private String name;
    private Set<AttributeDto> attributes = new HashSet<>();
}

package com.example.petfinder.controller.response;

import com.example.petfinder.dto.animal.AnimalDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class AnimalsByTypeResponse {

    private Long typeId;
    private List<AnimalResponse> animalResponseList;

    public static AnimalsByTypeResponse mapFromAnimalsList(List<AnimalDto> animalsList, Long typeId){
        List<AnimalResponse> animalResponseList = animalsList.stream()
                .map(AnimalResponse::mapFromAnimalDto)
                .collect(Collectors.toList());
        return new AnimalsByTypeResponse(typeId, animalResponseList);
    }
}

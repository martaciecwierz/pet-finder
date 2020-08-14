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
public class AnimalsByShelterResponse {

    private Long shelterId;
    private List<AnimalResponse> animalResponseList;

    public static AnimalsByShelterResponse mapFromAnimalsList(List<AnimalDto> animalList, Long shelterId){
        List<AnimalResponse> animalResponseList = animalList.stream()
                .map(AnimalResponse::mapFromAnimalDto)
                .collect(Collectors.toList());
        return new AnimalsByShelterResponse(shelterId, animalResponseList);
    }
}

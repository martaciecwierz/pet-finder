package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddAnimalRequest;
import com.example.petfinder.controller.request.UpdateAnimalRequest;
import com.example.petfinder.controller.response.AnimalResponse;
import com.example.petfinder.controller.response.AnimalsByShelterResponse;
import com.example.petfinder.controller.response.AnimalsByTypeResponse;
import com.example.petfinder.dto.animal.AnimalDto;
import com.example.petfinder.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("animal/{animalId}")
    public AnimalResponse getAnimalById(@PathVariable Long animalId){
        AnimalDto animalDto =  animalService.findAnimalById(animalId);
        return AnimalResponse.mapFromAnimalDto(animalDto);
    }

    @PostMapping("animal")
    public ResponseEntity addNewAnimal(@RequestBody AddAnimalRequest addAnimalRequest){
        animalService.addNewAnimal(addAnimalRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("animal")
    public AnimalResponse updateAnimalProfile(@RequestBody UpdateAnimalRequest updateAnimalRequest){
        AnimalDto animalDto = updateAnimalRequest.mapToAnimalDto();
        AnimalDto updatedAnimalDto =  animalService.updateAnimalProfile(animalDto);
        return AnimalResponse.mapFromAnimalDto(updatedAnimalDto);
    }

    @GetMapping("animals/type/{animalTypeId}")
    public AnimalsByTypeResponse getAnimalsByType(@PathVariable Long animalTypeId){
        List<AnimalDto> animalsList = animalService.findByAnimalType(animalTypeId);
        return AnimalsByTypeResponse.mapFromAnimalsList(animalsList, animalTypeId);
    }

    @GetMapping("animals/shelter/{shelterId}")
    public AnimalsByShelterResponse getAnimalsByShelter(@PathVariable Long shelterId){
        List<AnimalDto> animalsList = animalService.findByShelter(shelterId);
        return AnimalsByShelterResponse.mapFromAnimalsList(animalsList, shelterId);
    }



}

package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddAnimalAttributeRequest;
import com.example.petfinder.dto.animal.AnimalAttributeDto;
import com.example.petfinder.service.AnimalAttributeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AnimalAttributeController {

    private AnimalAttributeService animalAttributeService;

    public AnimalAttributeController(AnimalAttributeService animalAttributeService) {
        this.animalAttributeService = animalAttributeService;
    }

    @GetMapping("animalAttribute/{id}")
    public AnimalAttributeDto findById(@PathVariable Long id) {
        return animalAttributeService.findAnimalAttributeById(id);
    }

    @PostMapping("animalAttribute")
    public AnimalAttributeDto addAnimalAttribute(@RequestBody AddAnimalAttributeRequest addAnimalAttributeRequest) {
        return animalAttributeService.addAnimalAttribute(
                addAnimalAttributeRequest.getAnimalId(),
                addAnimalAttributeRequest.getAttributeId(),
                addAnimalAttributeRequest.getValue()
        );
    }
}

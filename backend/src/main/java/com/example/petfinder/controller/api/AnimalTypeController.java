package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddAnimalTypeRequest;
import com.example.petfinder.dto.animal.AnimalTypeDto;
import com.example.petfinder.service.AnimalTypeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AnimalTypeController {

    private AnimalTypeService animalTypeService;

    public AnimalTypeController(AnimalTypeService animalTypeService) {
        this.animalTypeService = animalTypeService;
    }

    @GetMapping("animalType/{id}")
    public AnimalTypeDto findById(@PathVariable Long id) {
        return animalTypeService.findAnimalTypeById(id);
    }

    @PostMapping("animalType")
    public AnimalTypeDto addAnimalType(@RequestBody AddAnimalTypeRequest addAnimalTypeRequest) {
        return animalTypeService.addAnimalType(addAnimalTypeRequest);
    }
}

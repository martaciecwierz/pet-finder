package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddAnimalTypeRequest;
import com.example.petfinder.controller.request.AddAttributeToAnimalTypeRequest;
import com.example.petfinder.controller.response.AnimalTypeResponse;
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
    public AnimalTypeResponse findById(@PathVariable Long id) {
        AnimalTypeDto animalTypeDto = animalTypeService.findAnimalTypeById(id);
        return new AnimalTypeResponse(animalTypeDto.getId(), animalTypeDto.getName());
    }

    @PostMapping("animalType")
    public AnimalTypeResponse addAnimalType(@RequestBody AddAnimalTypeRequest addAnimalTypeRequest) {
        AnimalTypeDto animalTypeDto = animalTypeService.addAnimalType(addAnimalTypeRequest);
        return new AnimalTypeResponse(animalTypeDto.getId(), animalTypeDto.getName());
    }

    @PutMapping("animalType/attribute")
    public AnimalTypeDto addAttributeToAnimalType(@RequestBody AddAttributeToAnimalTypeRequest addAttributeToAnimalTypeRequest) {
        return animalTypeService.addAttributeToAnimalType(
                addAttributeToAnimalTypeRequest.getAttributeId(),
                addAttributeToAnimalTypeRequest.getAnimalTypeId()
        );
    }
}

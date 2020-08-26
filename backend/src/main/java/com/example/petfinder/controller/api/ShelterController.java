package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddShelterRequest;
import com.example.petfinder.controller.response.ShelterListResponse;
import com.example.petfinder.dto.shelter.ShelterDto;
import com.example.petfinder.service.ShelterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class ShelterController {

    private ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping("shelter/{id}")
    public ShelterDto findById(@PathVariable Long id) {
        return shelterService.findShelterById(id);
    }

    @PostMapping("shelter")
    public ShelterDto addShelter(@RequestBody AddShelterRequest addShelterRequest) {
        return shelterService.addShelter(addShelterRequest.mapToDto());
    }

    @GetMapping("shelter/city/{city}")
    public ShelterListResponse findByCity(@PathVariable String city) {
        return new ShelterListResponse(shelterService.findShelterByCity(city));
    }
}

package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddShelterRequest;
import com.example.petfinder.controller.response.ShelterListResponse;
import com.example.petfinder.dto.shelter.ShelterDto;
import com.example.petfinder.service.ShelterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("shelter")
    public ShelterDto updateShelter(@RequestBody ShelterDto shelterDto) {
        return shelterService.updateShelter(shelterDto);
    }

    @DeleteMapping("shelter/{id}")
    public ResponseEntity deleteShelter(@PathVariable Long id) {
        shelterService.deleteShelter(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("shelters")
    public ShelterListResponse getAllShelters() {
        return new ShelterListResponse(shelterService.findAllShelters());
    }

    @GetMapping("shelter/city/{city}")
    public ShelterListResponse findByCity(@PathVariable String city) {
        return new ShelterListResponse(shelterService.findShelterByCity(city));
    }
}

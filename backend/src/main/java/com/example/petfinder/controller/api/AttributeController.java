package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddAttributeRequest;
import com.example.petfinder.controller.request.UpdateAttributeRequest;
import com.example.petfinder.controller.response.AttributeResponse;
import com.example.petfinder.controller.response.ListAttributesResponse;
import com.example.petfinder.dto.animal.AttributeDto;
import com.example.petfinder.service.AttributeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AttributeController {

    private AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping("attribute/{id}")
    public AttributeResponse findById(@PathVariable Long id) {
        AttributeDto attributeDto = attributeService.findAttributeById(id);
        return new AttributeResponse(attributeDto.getId(), attributeDto.getName(), attributeDto.getType());
    }

    @PostMapping("attribute")
    public AttributeResponse addAttribute(@RequestBody AddAttributeRequest addAttributeRequest) {
        AttributeDto attributeDto = attributeService.addAttribute(addAttributeRequest.getName(), addAttributeRequest.getType());
        return new AttributeResponse(attributeDto.getId(), attributeDto.getName(), attributeDto.getType());

    }

    @GetMapping("attributes")
    public ListAttributesResponse findAllAttributes() {
        return new ListAttributesResponse(attributeService.findAllAttributes());
    }

    @PutMapping("attribute")
    public AttributeResponse updateAttribute(@RequestBody UpdateAttributeRequest updateAttributeRequest) {
        AttributeDto attributeDto = attributeService.updateAttribute(updateAttributeRequest.getId(), updateAttributeRequest.getName(), updateAttributeRequest.getType());
        return new AttributeResponse(attributeDto.getId(), attributeDto.getName(), attributeDto.getType());
    }

    @DeleteMapping("attribute/{id}")
    public ResponseEntity deleteAttribute(@PathVariable Long id) {
        attributeService.deleteAttribute(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

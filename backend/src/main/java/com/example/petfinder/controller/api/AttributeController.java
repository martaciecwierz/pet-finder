package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddAttributeRequest;
import com.example.petfinder.controller.response.ListAttributesResponse;
import com.example.petfinder.dto.animal.AttributeDto;
import com.example.petfinder.service.AttributeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AttributeController {

    private AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping("attribute/{id}")
    public AttributeDto findById(@PathVariable Long id) {
        return attributeService.findAttributeById(id);
    }

    @PostMapping("attribute")
    public AttributeDto addAttribute(@RequestBody AddAttributeRequest addAttributeRequest) {
        return attributeService.addAttribute(addAttributeRequest.getName(), addAttributeRequest.getType());
    }

    @GetMapping("attributes")
    public ListAttributesResponse findAllAttributes() {
        return new ListAttributesResponse(attributeService.findAllAttributes());
    }
}

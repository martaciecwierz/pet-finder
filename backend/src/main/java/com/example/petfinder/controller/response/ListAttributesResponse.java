package com.example.petfinder.controller.response;

import com.example.petfinder.dto.animal.AttributeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ListAttributesResponse {

    List<AttributeResponse> attributes;

    public ListAttributesResponse(List<AttributeDto> attributes) {
        this.attributes = attributes.stream()
                .map(attribute -> new AttributeResponse(attribute.getId(), attribute.getName(), attribute.getType()))
                .collect(Collectors.toList());
    }
}

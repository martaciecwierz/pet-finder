package com.example.petfinder.controller.response;

import com.example.petfinder.dto.animal.AttributeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListAttributesResponse {

    List<AttributeDto> attributes;
}

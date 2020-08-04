package com.example.petfinder.dto.action;

import com.example.petfinder.dto.animal.AnimalDto;
import com.example.petfinder.dto.request.RequestDto;
import com.example.petfinder.dto.shelter.ShelterDto;
import com.example.petfinder.dto.user.UserDto;
import lombok.Data;

import java.util.Date;

@Data
public class ActionDto {

    private Long id;
    private UserDto userDto;
    private RequestDto requestDto;
    private ShelterDto shelterDto;
    private AnimalDto animalDto;
    private ActionTypeDto actionTypeDto;
    private int userRate;
    private int shelterRate;
    private int quantity;
    private Date date;
    private boolean isDone;

}

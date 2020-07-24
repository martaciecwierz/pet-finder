package com.example.petfinder.controller.request;

import com.example.petfinder.dto.user.UserDto;
import lombok.Data;

@Data
public class UpdateProfileRequest {

    private String firstName;
    private String lastName;
    private String email;

    public UserDto mapToUserDto() {
        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        return userDto;
    }
}

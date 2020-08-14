package com.example.petfinder.controller.response;

import com.example.petfinder.dto.user.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public static UserResponse mapFromUserDto(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        userResponse.id = userDto.getId();
        userResponse.username = userDto.getUsername();
        userResponse.firstName = userDto.getFirstName();
        userResponse.lastName = userDto.getLastName();
        userResponse.email = userDto.getEmail();
        return userResponse;
    }
}

package com.example.petfinder.controller.request;

import com.example.petfinder.dto.user.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private int rights;

    public UserDto mapToUserDto(){
        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setEmail(email);
        userDto.setRights(rights);

        return userDto;
    }

}

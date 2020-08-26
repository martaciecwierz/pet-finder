package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.RegisterUserRequest;
import com.example.petfinder.controller.response.UserResponse;
import com.example.petfinder.dto.user.UserDto;
import com.example.petfinder.service.common.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("register")
    public UserResponse registerUser(@RequestBody RegisterUserRequest request) {
        UserDto userDto = request.mapToUserDto();
        return UserResponse.mapFromUserDto(registrationService.registerUser(userDto));
    }
}

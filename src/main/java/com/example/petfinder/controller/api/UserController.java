package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.ChangePasswordRequest;
import com.example.petfinder.controller.request.UpdateProfileRequest;
import com.example.petfinder.dto.user.UserDto;
import com.example.petfinder.model.user.User;
import com.example.petfinder.security.AppUserPrincipal;
import com.example.petfinder.security.AuthenticationFacade;
import com.example.petfinder.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class UserController {

    private UserService userService;
    private AuthenticationFacade authenticationFacade;

    public UserController(UserService userService, AuthenticationFacade authenticationFacade) {
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
    }

    @PutMapping("user/password")
    public ResponseEntity changeUserPassword(@RequestBody ChangePasswordRequest request){
        Long userId = authenticationFacade.getLoggedUserId();
        userService.changePassword(userId, request.getNewPassword(), request.getOldPassword());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("user/profile")
    public UserDto updateUserProfile(@RequestBody UpdateProfileRequest request){
        Long userId = authenticationFacade.getLoggedUserId();
        UserDto userDto = request.mapToUserDto();
        userDto.setId(userId);
        return userService.updateProfile(userDto);
    }
}

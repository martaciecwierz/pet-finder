package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.ChangePasswordRequest;
import com.example.petfinder.controller.request.UpdateProfileRequest;
import com.example.petfinder.controller.response.UserListResponse;
import com.example.petfinder.controller.response.UserResponse;
import com.example.petfinder.dto.user.UserDto;
import com.example.petfinder.security.AuthenticationFacade;
import com.example.petfinder.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserResponse updateUserProfile(@RequestBody UpdateProfileRequest request) {
        Long userId = authenticationFacade.getLoggedUserId();
        UserDto userDto = request.mapToUserDto();
        userDto.setId(userId);
        UserDto updatedUserDto = userService.updateProfile(userDto);
        return UserResponse.mapFromUserDto(updatedUserDto);
    }

    @DeleteMapping("user")
    public ResponseEntity deactivateLoggedUser() {
        Long userId = authenticationFacade.getLoggedUserId();
        userService.deactivateUserProfile(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity deactivateUserById(@PathVariable Long userId) {
        userService.deactivateUserProfile(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("user/profile")
    public UserResponse getCurrentLoggedProfile() {
        Long userId = authenticationFacade.getLoggedUserId();
        return UserResponse.mapFromUserDto(userService.findUserById(userId));
    }

    @GetMapping("user/{userId}")
    public UserResponse getUserById(@PathVariable Long userId) {
        return UserResponse.mapFromUserDto(userService.findUserById(userId));
    }

    @GetMapping("user/email/{email}")
    public UserResponse getUserByEmail(@PathVariable String email) {
        return UserResponse.mapFromUserDto(userService.findUserByEmail(email));
    }

    @GetMapping("users/firstname/{firstName}/lastname/{lastName}")
    public UserListResponse allUsersContainingInName(@PathVariable String firstName, @PathVariable String lastName) {
        return UserListResponse.mapFromUserList(userService.findByFirstNameOrLastNameContaining(firstName, lastName));
    }

    @GetMapping("users")
    public UserListResponse getAllUsers() {
        return UserListResponse.mapFromUserList(userService.findAllUsers());
    }
}

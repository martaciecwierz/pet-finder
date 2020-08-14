package com.example.petfinder.controller.response;

import com.example.petfinder.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class UserListResponse {

    List<UserResponse> userResponseList;

    public static UserListResponse mapFromUserList(List<UserDto> userList) {
        List<UserResponse> userResponseList = userList.stream()
                .map(UserResponse::mapFromUserDto)
                .collect(Collectors.toList());
        return new UserListResponse(userResponseList);
    }
}

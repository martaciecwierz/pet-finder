package com.example.petfinder.controller.request;

import lombok.Data;

@Data
public class ChangePasswordRequest {

    private String newPassword;
    private String oldPassword;

}

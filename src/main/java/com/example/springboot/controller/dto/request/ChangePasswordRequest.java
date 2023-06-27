package com.example.springboot.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor

public class ChangePasswordRequest {

    @NotNull
    private String currentPassword;

    @NotNull
    private String newPassword;
}

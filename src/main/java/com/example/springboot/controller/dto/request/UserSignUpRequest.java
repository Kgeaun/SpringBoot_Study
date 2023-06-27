package com.example.springboot.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotBlank
    @Size(min = 8, max = 20)
    private String accountId;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotBlank
    @Size(max = 8)
    private String name;
}

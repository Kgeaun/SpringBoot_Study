package com.example.springboot.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class ChangeAccountIdRequest {

    @NotNull // TODO: 2023/05/22 NotNull, NotEmpty, NotBlank 알아보자ㅏ
    private String currentAccountId;

    @NotNull
    private String newAccountId;
}


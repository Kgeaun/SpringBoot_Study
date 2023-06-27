package com.example.springboot.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserElement {

    private final String accountId;
    private final String password;
    private final String name;
}

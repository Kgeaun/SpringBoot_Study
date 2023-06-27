package com.example.springboot.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    EXPIRED_TOKEN(401, "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),

    USER_NOT_FOUND(404, "user not found"),
    USER_ALREADY_EXISTS(409, "user already exists"),
    PASSWORD_MISMATCH(404, "password mismatch");

    private final int code;
    private final String message;
}

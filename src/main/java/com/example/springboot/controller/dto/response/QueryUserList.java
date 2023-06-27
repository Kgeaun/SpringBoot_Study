package com.example.springboot.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryUserList {

    private List<QueryUserElement> userList;
}

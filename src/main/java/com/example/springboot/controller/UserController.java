package com.example.springboot.controller;

import com.example.springboot.controller.dto.request.ChangeAccountIdRequest;
import com.example.springboot.controller.dto.request.ChangePasswordRequest;
import com.example.springboot.controller.dto.request.UserSignUpRequest;
import com.example.springboot.controller.dto.response.QueryUserResponse;
import com.example.springboot.controller.dto.response.QueryUserList;
import com.example.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest userSignUpRequest) {
        userService.signUp(userSignUpRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/accountId")
    public void changeAccountId(@RequestBody @Valid ChangeAccountIdRequest changeAccountIdRequest) {
        userService.changeAccountId(changeAccountIdRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{account-id}")
    public void deleteUser(@PathVariable("account-id") String accountId) {
        userService.deleteUser(accountId);
    }

    @GetMapping
    public QueryUserList queryUserList() {
        return userService.getUserList();
    }

    @GetMapping("/{account-id}")
    public QueryUserResponse queryAccountId(@PathVariable("account-id") String accountId) {
        return userService.getUserAccountId(accountId);
    }
    // TODO: 2023/05/30 삭제 -> 내 정보 조히하는거
    // TODO: 2023/05/30 Pathvariable, RequestParam

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/password")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest) {
        userService.changePassword(changePasswordRequest);
    }
}

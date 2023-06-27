package com.example.springboot.service;

import com.example.springboot.controller.dto.request.ChangeAccountIdRequest;
import com.example.springboot.controller.dto.request.ChangePasswordRequest;
import com.example.springboot.controller.dto.request.UserSignUpRequest;
import com.example.springboot.controller.dto.response.QueryUserResponse;
import com.example.springboot.controller.dto.response.QueryUserElement;
import com.example.springboot.controller.dto.response.QueryUserList;
import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void signUp(UserSignUpRequest userSignUpRequest) {
        userRepository.save(
                User.builder()
                        .accountId(userSignUpRequest.getAccountId())
                        .password(userSignUpRequest.getPassword())
                        .name(userSignUpRequest.getName())
                        .build());
    }

    @Transactional
    public void changeAccountId(ChangeAccountIdRequest changeAccountIdRequest) {
        User user = userRepository.findByAccountId(changeAccountIdRequest.getCurrentAccountId())
                .orElseThrow(() -> new RuntimeException());

        user.changeAccountId(changeAccountIdRequest.getNewAccountId());
    }

    @Transactional
    public void deleteUser(String accountId) {
        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException());

        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    public QueryUserList getUserList() {
        return new QueryUserList(
                userRepository.findAll()
                        .stream()
                        .map(user -> QueryUserElement.builder()
                                .accountId(user.getAccountId())
                                .password(user.getPassword())
                                .name(user.getName())
                                .build()
                        )
                        .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public QueryUserResponse getUserAccountId(String accountId) {
        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException());
        return new QueryUserResponse(user.getAccountId());
    }

    // TODO: 2023/05/30 유저 객체 하나만 조회 accountId로 찾아서 유저 정보 하나만 조회하기
    @Transactional
    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findByPassword(changePasswordRequest.getCurrentPassword())
                .orElseThrow(RuntimeException::new);

        user.changePassword(changePasswordRequest.getNewPassword());
    }

}


// TODO: 2023/05/30 영속성 컨텍스트
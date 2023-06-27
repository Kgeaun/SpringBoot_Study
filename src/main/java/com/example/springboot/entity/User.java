package com.example.springboot.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20, nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false) // TODO: 비밀번호(중요함) -> 암호화 필요 -> 암호화를 거치면 60자가 됨 무조건!! -> CHAR(60)
    private String password;

    @Column(length = 5, nullable = false)
    private String name;

    @Builder
    public User(String accountId, String password, String name) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
    }

    public void changeAccountId(String accountId) {
        this.accountId =  accountId;
    }

    public void changePassword(String password){
        this.password = password;
    }

}

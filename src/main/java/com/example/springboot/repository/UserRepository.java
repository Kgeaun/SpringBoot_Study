package com.example.springboot.repository;

import com.example.springboot.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByAccountId(String accountId);

    Optional<User> findByAccountId(String accountId); // null값

    boolean existsByPassword(String password);

    Optional<User> findByPassword(String password);

    List<User> findAll();
}


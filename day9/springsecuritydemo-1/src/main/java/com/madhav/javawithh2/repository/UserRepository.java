package com.madhav.javawithh2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhav.javawithh2.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
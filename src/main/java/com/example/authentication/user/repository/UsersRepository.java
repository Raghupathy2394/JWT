package com.example.authentication.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authentication.user.entity.Users;

public interface UsersRepository extends JpaRepository<Users, UUID> {

}

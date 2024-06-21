package com.example.authentication.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

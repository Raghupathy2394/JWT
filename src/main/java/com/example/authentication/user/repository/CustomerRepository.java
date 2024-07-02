package com.example.authentication.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.user.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}

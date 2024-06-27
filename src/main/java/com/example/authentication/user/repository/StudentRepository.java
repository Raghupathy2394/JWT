package com.example.authentication.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.user.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}

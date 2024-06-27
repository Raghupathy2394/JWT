package com.example.authentication.user.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.authentication.user.dto.DtoPageStudent;
import com.example.authentication.user.entity.Student;

public interface StudentServiceImp {

	Student create(Student student);

	
	//////////////*********pagination****///////////
	
	DtoPageStudent<Student> getStudents(int page, int size);


	DtoPageStudent<Student> getStudentsort(int page, int size);


	Page<Student> getPages(int page, int size);


	List<Student> getAll();

}

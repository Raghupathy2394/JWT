package com.example.authentication.user.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.authentication.user.dto.DtoPageStudent;
import com.example.authentication.user.dto.RequestMeta;
import com.example.authentication.user.entity.Student;
import com.example.authentication.user.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceImp {

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	RequestMeta requestmeta;
	
	///////////////*****************pagination using DTO******///////////////
	@Override
	public DtoPageStudent<Student> getStudents(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Student> page1 = studentRepo.findAll(pageable);
        DtoPageStudent<Student> student=new DtoPageStudent<Student>();
        student.setContent(page1.getContent());
        student.setPageSize(page1.getSize());
        student.setLast(page1.isLast());
        student.setTotalElements(page1.getNumberOfElements());
        student.setTotalPage(page1.getTotalPages());
        return student;     
	}
	
	///////////////****************sorting ********/////////////
	
	@Override
	public DtoPageStudent<Student> getStudentsort(int page, int size) {
		  Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
		    Page<Student> page1 = studentRepo.findAll(pageable);
	        DtoPageStudent<Student> student=new DtoPageStudent<Student>();
	        student.setContent(page1.getContent());
	        student.setPageSize(page1.getSize());
	        student.setLast(page1.isLast());
	        student.setTotalElements(page1.getNumberOfElements());
	        student.setTotalPage(page1.getTotalPages());
	        return student;     
	}
	////*******pagination using Entity********//////
	
	@Override
	public Page<Student> getPages(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return studentRepo.findAll(pageable);
	}
	
	
	
	@Override
	public Student create(Student student) {
	
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAll() {
		System.out.println(requestmeta.getUserType());
		System.out.println(requestmeta.getEmailId());
		return studentRepo.findAll();
	}

	
	
}

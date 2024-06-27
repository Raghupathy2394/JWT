package com.example.authentication.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="studentdata")
@Data

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="dept")
	private String dept;
	
	@Column(name="age")
	private int age;
	
	 @Column(name="mobileNo")
	private long mobileNo;
}


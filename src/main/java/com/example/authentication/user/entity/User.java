package com.example.authentication.user.entity;

import com.example.authentication.user.common.Constant;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data

public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private String emailId;
	private String mobileNumber;
    private String userType=Constant.USER_TYPE.NARMAL;
	private String password;
	private int loginCount = 0;
	private boolean isActive;
	private String ssoType;
	
	}
	


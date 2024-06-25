package com.example.authentication.user.entity;

import com.example.authentication.user.common.Constant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data

public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String gender;
	private String emailid;
	private String mobileNumber;
    private String userType=Constant.USER_TYPE.NORMAL;
	private String password;
	private int loginCount = 0;
	private boolean isActive;
	private String ssoType;
	
	}
	


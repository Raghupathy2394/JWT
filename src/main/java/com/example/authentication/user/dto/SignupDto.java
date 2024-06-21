package com.example.authentication.user.dto;

import lombok.Data;

@Data
public class SignupDto {

	private String name;
	private String gender;
	private String emailId;
	private String mobileNumber;
	private String password;
	
}

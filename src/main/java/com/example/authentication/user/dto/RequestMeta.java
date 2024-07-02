package com.example.authentication.user.dto;

import lombok.Data;

@Data
public class RequestMeta {
	
	private Long userId;
	
	private String userNme;
	
	private String emailId;
	
	private String userType;

}

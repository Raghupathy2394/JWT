package com.example.authentication.user.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	public ResponseEntity<UserResponse> handleAccessDeniedException(AccessDeniedException e) {
		UserResponse userResponse=new UserResponse();
		userResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
	}

}

package com.example.authentication.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.authentication.user.common.UserResponse;
import com.example.authentication.user.dto.LogInDto;
import com.example.authentication.user.dto.SignupDto;
import com.example.authentication.user.service.UserServiceImp;

@Controller
public class LoginController {
	@Autowired
	UserServiceImp userService;
	
@PostMapping("/userSignUp")
public ResponseEntity<UserResponse> signUp(@RequestBody SignupDto signDto){
	UserResponse userResponse=userService.signUp(signDto);
	return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
}
@PostMapping("/userLogin")
public ResponseEntity<UserResponse> logIn(@RequestBody LogInDto loginDto){
	UserResponse userResponse=userService.logIn(loginDto);
	return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
}
}

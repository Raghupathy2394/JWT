
package com.example.authentication.user.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.authentication.user.common.Jwtoken;
import com.example.authentication.user.common.UserResponse;
import com.example.authentication.user.dto.LogInDto;
import com.example.authentication.user.dto.SignupDto;
import com.example.authentication.user.entity.User;
import com.example.authentication.user.service.UserServiceImp;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Autowired
	UserServiceImp userService;
	
	@Autowired
	Jwtoken jwtToken;
	
@PostMapping("/signup")
public ResponseEntity<UserResponse> signUp(@RequestBody SignupDto signDto){
	UserResponse userResponse=userService.signUp(signDto);
	return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
}
@PostMapping("/login")
public ResponseEntity<UserResponse> logIn(@RequestBody LogInDto loginDto){
	UserResponse userResponse=userService.logIn(loginDto);
	return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
}

@GetMapping("/privateApi")
public ResponseEntity<UserResponse> privateApi(@RequestHeader
		(value="authorization",defaultValue="")
String author) throws Exception {
	UserResponse userResponse=userService.privateApi(author);
	return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
}

@GetMapping("/validate")
public ResponseEntity<UserResponse> validate(@RequestBody LogInDto loginDto){
	UserResponse userResponse=userService.validatePassword(loginDto);
	return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
}












//@GetMapping("/getAll")
//public List<User> getAll(@RequestParam(value="name",required = false)String name){
//	return userService.getAllUser(name);
//}
}

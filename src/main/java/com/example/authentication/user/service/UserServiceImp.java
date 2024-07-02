package com.example.authentication.user.service;

import java.util.List;

import com.example.authentication.user.common.UserResponse;
import com.example.authentication.user.dto.LogInDto;
import com.example.authentication.user.dto.SignupDto;
import com.example.authentication.user.entity.User;

public interface UserServiceImp {

	UserResponse signUp(SignupDto signDto);

	UserResponse logIn(LogInDto loginDto);

	UserResponse privateApi(String author) throws Exception;

	UserResponse validatePassword(LogInDto loginDto);

//	List<User> getAllUser(String name);

	

	
}

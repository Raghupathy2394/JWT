package com.example.authentication.user.service;

import com.example.authentication.user.common.UserResponse;
import com.example.authentication.user.dto.SignupDto;

public interface UserServiceImp {

	UserResponse signUp(SignupDto signDto);

	
}

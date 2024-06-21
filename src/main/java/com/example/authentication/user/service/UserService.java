package com.example.authentication.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.user.common.UserResponse;
import com.example.authentication.user.dto.SignupDto;
import com.example.authentication.user.entity.User;
import com.example.authentication.user.repository.UserRepository;

@Service
public class UserService implements UserServiceImp{
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserResponse signUp(SignupDto signDto) {
		UserResponse userResponse=new UserResponse();
		 User userEntity=new User();
		 userEntity.setEmailId(signDto.getEmailId());
		 userEntity.setName(signDto.getName());
		 userEntity.setActive(true);
		 userEntity.setGender(signDto.getGender());
		 userEntity.setMobileNumber(signDto.getMobileNumber());
		 userEntity.setPassword(signDto.getPassword());
		userEntity= userRepo.save(userEntity);
		 userResponse.setData(userEntity);
		return userResponse;
	}
	
}

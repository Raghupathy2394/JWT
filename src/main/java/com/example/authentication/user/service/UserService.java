package com.example.authentication.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.user.common.Jwtoken;
import com.example.authentication.user.common.UserResponse;
import com.example.authentication.user.dto.LogInDto;
import com.example.authentication.user.dto.SignupDto;
import com.example.authentication.user.entity.User;
import com.example.authentication.user.repository.UserRepository;

@Service
public class UserService implements UserServiceImp{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	Jwtoken jwtToken;
	
	@Override
	public UserResponse signUp(SignupDto signDto) {
		UserResponse userResponse=new UserResponse();
		 User userEntity=new User();
		 userEntity.setEmailid(signDto.getEmailid());
		 userEntity.setName(signDto.getName());
		 userEntity.setActive(true);
		 userEntity.setGender(signDto.getGender());
		 userEntity.setMobileNumber(signDto.getMobileNumber());
		 userEntity.setPassword(signDto.getPassword());
		userEntity= userRepo.save(userEntity);
		 userResponse.setData(userEntity);
		return userResponse;
	}

	@Override
	public UserResponse logIn(LogInDto loginDto) {
		UserResponse userResponse=new UserResponse();
		User user=userRepo.findOneByEmailidIgnoreCaseAndPassword(loginDto.getEmailid(),loginDto.getPassword());
		if(user == null) {
			userResponse.setData("User login failed");
			return userResponse;
		} 
		String token =  jwtToken.generateJWT(user);
		userResponse.setData(token);
		return userResponse;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

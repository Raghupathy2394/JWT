package com.example.authentication.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.authentication.user.common.Jwtoken;
import com.example.authentication.user.common.UserResponse;
import com.example.authentication.user.dto.LogInDto;
import com.example.authentication.user.dto.SignupDto;
import com.example.authentication.user.entity.User;
import com.example.authentication.user.repository.UserRepository;

@Service
public class UserService implements UserServiceImp {

	@Autowired
	UserRepository userRepo;

	@Autowired
	Jwtoken jwtToken;

	@Override
	public UserResponse signUp(SignupDto signDto) {
		UserResponse userResponse = new UserResponse();
		User userEntity = new User();
		userEntity.setEmailid(signDto.getEmailid());
		userEntity.setName(signDto.getName());
		userEntity.setGender(signDto.getGender());
		userEntity.setMobileNumber(signDto.getMobileNumber());
		userEntity.setPassword(signDto.getPassword());

		if (userEntity.getPassword() == null || userEntity.getPassword().isEmpty()) {
			userResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			userResponse.setError("Bad Request");
			userResponse.setData("No data found");
		} else {
			userResponse.setStatus(HttpStatus.OK.value());
			userResponse.setData(userEntity);
			userRepo.save(userEntity);
			String token = jwtToken.generateJWT(userEntity);
			Map<String, Object> data = new HashMap<>();
			data.put("Access Token", token);
			userResponse.setData(data);						
		}
		return userResponse;
	}

	@Override
	public UserResponse logIn(LogInDto loginDto) {
		UserResponse userResponse = new UserResponse();
		User user = userRepo.findOneByEmailidPassword(loginDto.getEmailid(),
				loginDto.getPassword());
		if (user == null) {
			userResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			userResponse.setData("logIn failed");
			userResponse.setError("Bad Request");
		 return userResponse;
		} else {
			userResponse.setStatus(HttpStatus.OK.value());
		String token = jwtToken.generateJWT(user);
		Map<String, Object> data = new HashMap<>();
		data.put("Access Token", token);
		userResponse.setData(data);
		return userResponse;	
		}
	}

	@Override
	public UserResponse privateApi(String author) throws Exception {
		UserResponse userResponse = new UserResponse();
	//	String authorization="";
		if(author == null) {
			userResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		userResponse.setData("logIn failed");
		userResponse.setError("Oops something went wrong");
		return userResponse;
	} else	{
		jwtToken.verify(author);
		userResponse.setStatus(HttpStatus.OK.value());
		userResponse.setData("This is Private Api");
		return userResponse;
		
	}

	}
}

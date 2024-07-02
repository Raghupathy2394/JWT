package com.example.authentication.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.authentication.user.common.Jwtoken;
import com.example.authentication.user.common.UserResponse;
import com.example.authentication.user.config.PasswordUtil;
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
		userEntity.setPassword(PasswordUtil.getEncryptedPassword(signDto.getPassword()));

		if (userEntity.getPassword() == null || userEntity.getPassword().isEmpty()) {
			userResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			userResponse.setError("Bad Request");
			userResponse.setData("No data found");
			return userResponse;
		} else {
			userResponse.setStatus(HttpStatus.OK.value());
			userResponse.setData(userEntity);
			userRepo.save(userEntity);
			userResponse.setError("No Error Found");
//			String token = jwtToken.generateJWT(userEntity);
//			Map<String, Object> data = new HashMap<>();
//			data.put("Access Token", token);
//			userResponse.setData(data);		
			return userResponse;
		}
	}

	@Override
	public UserResponse logIn(LogInDto loginDto) {
		UserResponse userResponse = new UserResponse();
		User user = userRepo.findOneByEmailidPassword(loginDto.getEmailid(),
				PasswordUtil.getEncryptedPassword(loginDto.getPassword()));
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
			userResponse.setError("No Error Found");
			return userResponse;
		}
	}

	@Override
	public UserResponse privateApi(String author) throws Exception {
		UserResponse userResponse = new UserResponse();
		jwtToken.verify(author);
		userResponse.setStatus(HttpStatus.OK.value());
		userResponse.setData("This is Private Api");
		userResponse.setError("No Error Found");
		return userResponse;
	}

	@Override
	public UserResponse validatePassword(LogInDto loginDto) {
		UserResponse userResponse = new UserResponse();
		Optional<User> optional = userRepo.findByEmailId(loginDto.getEmailid());
		User user = optional.get();
		String realPassword = user.getPassword();
		String loginPassword = PasswordUtil.getEncryptedPassword(loginDto.getPassword());
		if (realPassword.equals(loginPassword)) {
			userResponse.setStatus(HttpStatus.OK.value());
			userResponse.setData("login Successfull");
			userResponse.setError("No Error Found");
		} 
		return userResponse;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public List<User> getAllUser(String name) {
//		List<User> user=userRepo.findAll();
//		List<SignupDto> signdto=new ArrayList<SignupDto>();
//		for(User e:user) {
//			SignupDto dto=new SignupDto();
//			dto.setName(e.getName());
//			dto.setEmailid(e.getEmailid());
//			dto.setGender(e.getGender());
//			dto.setMobileNumber(e.getMobileNumber());
//			dto.setPassword(e.getPassword());
//			signdto.add(dto);
//		} return user;
// }
}
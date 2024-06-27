package com.example.authentication.user.common;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.authentication.user.config.JwtInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
@Configuration
public class CustomWebConfig implements WebMvcConfigurer{

	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor);
			}
		
	}


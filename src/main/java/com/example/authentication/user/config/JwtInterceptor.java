package com.example.authentication.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.authentication.user.common.Jwtoken;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtInterceptor implements HandlerInterceptor{
	 
	@Autowired
	private Jwtoken jwtToken;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//	System.out.println(request.getRequestURI());
	String auth=request.getHeader( "authorization");
	if(!(request.getRequestURI().contains("login") || request.getRequestURI().
			contains("singup"))) {
	jwtToken.verify(auth);
	}
//	System.out.println(auth);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
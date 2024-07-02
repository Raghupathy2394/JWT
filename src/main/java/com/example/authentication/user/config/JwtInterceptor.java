package com.example.authentication.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.authentication.user.common.Jwtoken;
import com.example.authentication.user.dto.RequestMeta;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private Jwtoken jwtToken;

	@Autowired
	private RequestMeta requestMeta;

	public JwtInterceptor(RequestMeta requestMeta) {
		this.requestMeta = requestMeta;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//	System.out.println(request.getRequestURI());
		String auth = request.getHeader("authorization");
		if (!(request.getRequestURI().contains("user") || request.getRequestURI().contains("signup")  )) {
			Claims claims = jwtToken.verify(auth);
			requestMeta.setUserNme(claims.get("name").toString());
			requestMeta.setEmailId(claims.get("emailId").toString());
			requestMeta.setUserType(claims.get("type").toString());
			requestMeta.setUserId(Long.valueOf(claims.getIssuer()));
		}
//	System.out.println(auth);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}

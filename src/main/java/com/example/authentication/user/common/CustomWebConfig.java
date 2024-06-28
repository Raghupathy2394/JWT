package com.example.authentication.user.common;

import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.authentication.user.config.JwtInterceptor;
import com.example.authentication.user.dto.RequestMeta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
@Configuration
public class CustomWebConfig implements WebMvcConfigurer{

	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	
	@Override  
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor);
			}
	@Bean
	@RequestScope  // this or that
//	@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS )
		public RequestMeta getRequestMeta() {
			return new RequestMeta();
		}
	@Bean
	public JwtInterceptor Interceptor() {
		return new JwtInterceptor(getRequestMeta());
	}
			}
		

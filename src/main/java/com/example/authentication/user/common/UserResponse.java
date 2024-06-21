package com.example.authentication.user.common;

import org.springframework.http.HttpStatus;

import com.example.authentication.user.entity.User;


public class UserResponse {
	
    private User data;

    // Getters and Setters (or use Lombok @Data annotation)
    public HttpStatus getStatus() {
        return HttpStatus.OK;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}


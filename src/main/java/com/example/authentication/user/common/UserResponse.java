package com.example.authentication.user.common;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class UserResponse {

    private Integer status;
    private Object data;
    private Object error;

    public UserResponse() {
        this.status = HttpStatus.OK.value();
       
    }
}


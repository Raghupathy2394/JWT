package com.example.authentication.user.common;

import lombok.Data;

@Data
public class UserResponse {

    private Integer status;
    private Object data;
    private Object error;

}


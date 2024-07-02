package com.example.authentication.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.user.entity.Customer;
import com.example.authentication.user.service.CustomerServiceImp;

@RestController
@RequestMapping("/user")
public class CustomerController {
	
	@Autowired
	CustomerServiceImp serviceImp;
	
	@PostMapping("/post/both")
	public Customer postBoth(@RequestBody Customer customer) {
		return serviceImp.postBoth(customer);
	}

}

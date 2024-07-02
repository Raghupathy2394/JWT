package com.example.authentication.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.user.entity.Customer;
import com.example.authentication.user.entity.UserRole;
import com.example.authentication.user.entity.Users;
import com.example.authentication.user.repository.CustomerRepository;
import com.example.authentication.user.repository.UsersRepository;

@Service
public class CustomerService implements CustomerServiceImp{

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	UsersRepository usersRepo;
	
	@Override
	public Customer postBoth(Customer customer) {
		customerRepo.save(customer);
		Users user=new Users();
		user.setName(customer.getName());
		user.setEmailid(customer.getEmailid());
		user.setGender(customer.getGender());
		user.setMobileNumber(customer.getMobileNumber());
		user.setPassword(customer.getPassword());
		user.setUserRole(UserRole.CUSTOMER);
		usersRepo.save(user);
		return customer;
	}
	

}

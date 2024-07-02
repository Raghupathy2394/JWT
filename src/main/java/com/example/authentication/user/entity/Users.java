package com.example.authentication.user.entity;

import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "userdb")
@Data
public class Users {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;

	private String name;

	private String gender;

	private String emailid;

	private String mobileNumber;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	private String password;

}

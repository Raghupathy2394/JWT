package com.example.authentication.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.authentication.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value="select * from user where emailid=:emailid and password=:password",nativeQuery=true)
	User findOneByEmailidPassword(String emailid, String password);
	
		//User findOneByEmailIgnoreCasePassword(String emailid, String password);

}

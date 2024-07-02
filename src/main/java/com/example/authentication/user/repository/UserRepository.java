package com.example.authentication.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.authentication.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value="select * from user where emailid=:emailid and password=:password",nativeQuery=true)
	User findOneByEmailidPassword(String emailid, String password);

//	List<User> findByName(String name);

	@Query(value="select * from user where emailid=:emailid",nativeQuery=true)
	Optional<User> findByEmailId(String emailid);


		//User findOneByEmailIgnoreCasePassword(String emailid, String password);

}

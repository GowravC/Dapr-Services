package com.register.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.register.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	/**
	 * To get last User Id from table
	 * @return
	 */
	@Query("select max(userId) from User")
	public Integer getUserId();

	
	@Query("from User where user_name =:username and password =:password")
	public Optional<User> userVerfication(@Param("username") String username,
			@Param("password") String password);

}

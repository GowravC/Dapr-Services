package com.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.register.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	/**
	 * To get last Role Id from table
	 * 
	 * @return
	 */
	@Query("select max(roleId) from Role")
	public Integer getRoleId();

}

package com.register.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.register.entity.Role;

@Service
public interface IRoleService {


	public String addRole(Role role) throws Exception;

	public String updateRole(Role role) throws Exception;

	public List<Role> getAllRoles();

	public Role getRoleById(int roleId) throws Exception;

	public String deleteRoleById(int roleId) throws Exception;

}

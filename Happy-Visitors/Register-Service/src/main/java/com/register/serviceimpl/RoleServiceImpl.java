package com.register.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.entity.Role;
import com.register.helper.Helper;
import com.register.repository.RoleRepository;
import com.register.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private Helper helper;

	@Override
	public String addRole(Role role) throws Exception {
		Optional<Role> optional = roleRepo.findById(role.getRoleId());
		if (optional.isEmpty()) {
			// Setting the RoleID with the help of helper Class
			role.setRoleId(helper.genrateRoleId());
			Integer roleId = roleRepo.save(role).getRoleId();
			return "Role is added with ID: " + roleId;
		} else {
			return "Role Already Exist, new Role not Inserted";

		}
	}

	@Override
	public String updateRole(Role role) throws Exception {
		Optional<Role> optional = roleRepo.findById(role.getRoleId());
		if (optional.isPresent()) {
			roleRepo.save(role);
			return "Role with ID " + role.getRoleId() + " is Updated.....";
		} else {
			return "Role with Id " + role.getRoleId() + " not Found!!!";
		}
	}

	@Override
	public List<Role> getAllRoles() {
		System.out.println("Testing - get All Roles details");
		return null;
	}

	@Override
	public Role getRoleById(int roleId) throws Exception {
		System.out.println("Testing - get Role by Id");
		return null;
	}

	@Override
	public String deleteRoleById(int roleId) throws Exception {
		System.out.println("Testing - Role Deleted");
		return null;
	}

}

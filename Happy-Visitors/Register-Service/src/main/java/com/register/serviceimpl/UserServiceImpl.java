package com.register.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.entity.Role;
import com.register.entity.User;
import com.register.helper.Helper;
import com.register.repository.RoleRepository;
import com.register.repository.UserRepository;
import com.register.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private Helper helper;

	@Override
	public String addUser(User user) throws Exception {
		Optional<User> optional = userRepo.findById(user.getUserId());
		if (optional.isEmpty()) {
			// Setting the UserID with the help of helper Class
			user.setUserId(helper.genrateUserId());

			// Setting the Role object of user by fetching role object using roleId received
			// from user object
			Role role = roleRepo.findById(user.getRole().getRoleId()).get();
			user.setRole(role);
			Integer userId = userRepo.save(user).getUserId();
			return "User is Added with ID: " + userId;
		} else {
			return "User Already Exist, new user not Inserted";

		}
	}

	@Override
	public String updateUser(User user) throws Exception {
		Optional<User> optional = userRepo.findById(user.getUserId());
		if (optional.isPresent()) {
			// Setting the Role object of user by fetching role object using roleId received
			// from user object
			Role role = roleRepo.findById(user.getRole().getRoleId()).get();
			user.setRole(role);
			userRepo.save(user);
			return "User with ID " + user.getUserId() + " is Updated.....";
		} else {
			return "User with Id " + user.getUserId() + " not Found!!!";
		}
	}

	@Override
	public List<User> getAllUsers() {
		System.out.println("Testing - get All Users details");
		return null;
	}

	@Override
	public User getUserById(int userId) throws Exception {
		System.out.println("Testing - get User by Id");
		return null;
	}

	@Override
	public String deleteUserById(int userId) throws Exception {
		System.out.println("Testing - User Deleted");
		return null;
	}

}

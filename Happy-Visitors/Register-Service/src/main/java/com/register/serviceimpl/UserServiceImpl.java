package com.register.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.register.entity.User;
import com.register.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public String addUser(User user) throws Exception {
		System.out.println("Testing - User Added");
		return null;
	}

	@Override
	public String updateUser(User user) throws Exception {
		System.out.println("Testing - User Updated");
		return null;
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

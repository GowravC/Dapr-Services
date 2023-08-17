package com.register.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.register.entity.User;

@Service
public interface IUserService {


	public String addUser(User user) throws Exception;

	public String updateUser(User user) throws Exception;

	public List<User> getAllUsers();

	public User getUserById(int userId) throws Exception;

	public String deleteUserById(int userId) throws Exception;

}

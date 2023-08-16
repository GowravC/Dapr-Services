package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.entity.User;
import com.register.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
/**
 * User operations controller
 * 
 * @author gowrav.c
 *
 */
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * This API is used to insert a user object into DB
	 * 
	 * @param user taking the user object in JSON
	 * @return Response entity String
	 */
	@PostMapping("/insert")
	@ApiOperation("To register the User")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		try {
			String rs = userService.addUser(user);
			return new ResponseEntity<String>(rs, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to update the user object
	 * 
	 * @param user accepts the user object in JSON
	 * @return String - updated message
	 */
	@PutMapping("/update")
	@ApiOperation("To update the user details")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		try {
			String rs = userService.updateUser(user);
			return new ResponseEntity<String>(rs, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to fetch all the users details
	 * 
	 * @return List of User objects
	 */
	@GetMapping("/fetchAll")
	@ApiOperation("To fetch all user details")
	public ResponseEntity<?> fetchAll() {
		try {
			List<User> list = userService.getAllUsers();
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching User records.. Please Try Again.....",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to fetch the particular user by user ID
	 * 
	 * @param id accepts user ID
	 * 
	 * @return user object
	 */
	@GetMapping("/fetch/{userId}")
	@ApiOperation("To get the user details from userId")
	public ResponseEntity<?> fetchUserById(@PathVariable int userId) {
		try {
			User user = userService.getUserById(userId);
			return new ResponseEntity<User>(user, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This API is used to delete the user object from DB
	 * 
	 * @param id accepts user ID to delete the object
	 * @return String - message
	 */
	@DeleteMapping("/delete/{userId}")
	@ApiOperation("To delete the user from userId")
	public ResponseEntity<?> deleteUserById(@PathVariable int userId) {
		try {
			String msg = userService.deleteUserById(userId);
			return new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}

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

import com.register.entity.Role;
import com.register.service.IRoleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/role")
/**
 * Role operations controller
 * 
 * @author gowrav.c
 *
 */
public class RoleController {

	@Autowired
	private IRoleService roleService;

	/**
	 * This API is used to insert a role object into DB
	 * 
	 * @param role taking the role object in JSON
	 * @return Response entity String
	 */
	@PostMapping("/insert")
	@ApiOperation("To register the Role")
	public ResponseEntity<String> addRole(@RequestBody Role role) {
		try {
			String rs = roleService.addRole(role);
			return new ResponseEntity<String>(rs, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to update the role object
	 * 
	 * @param role accepts the role object in JSON
	 * @return String - updated message
	 */
	@PutMapping("/update")
	@ApiOperation("To update the role details")
	public ResponseEntity<String> updateRole(@RequestBody Role role) {
		try {
			String rs = roleService.updateRole(role);
			return new ResponseEntity<String>(rs, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to fetch all the roles details
	 * 
	 * @return List of Role objects
	 */
	@GetMapping("/fetchAll")
	@ApiOperation("To fetch all role details")
	public ResponseEntity<?> fetchAll() {
		try {
			List<Role> list = roleService.getAllRoles();
			return new ResponseEntity<List<Role>>(list, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Role records.. Please Try Again.....",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This API is used to fetch the particular role by role ID
	 * 
	 * @param id accepts role ID
	 * 
	 * @return role object
	 */
	@GetMapping("/fetch/{roleId}")
	@ApiOperation("To get the role details from roleId")
	public ResponseEntity<?> fetchRoleById(@PathVariable int roleId) {
		try {
			Role role = roleService.getRoleById(roleId);
			return new ResponseEntity<Role>(role, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This API is used to delete the role object from DB
	 * 
	 * @param id accepts role ID to delete the object
	 * @return String - message
	 */
	@DeleteMapping("/delete/{roleId}")
	@ApiOperation("To delete the role from roleId")
	public ResponseEntity<?> deleteRoleById(@PathVariable int roleId) {
		try {
			String msg = roleService.deleteRoleById(roleId);
			return new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}

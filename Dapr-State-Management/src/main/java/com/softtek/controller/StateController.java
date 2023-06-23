package com.softtek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.service.StateService;

@RestController
public class StateController {

	@Autowired
	private StateService stateService;

	@PostMapping("/state/{key}")
	public ResponseEntity<?> saveState(@PathVariable String key, @RequestBody String value) {
		try {
			String rs = stateService.saveState(key, value);
			return new ResponseEntity<String>(rs, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in Saving the state of Key: " + key,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/state/{key}")
	public ResponseEntity<?> getState(@PathVariable String key) {
		try {
			String rs = stateService.getState(key);
			return new ResponseEntity<String>(rs, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in getting the state of Key: " + key,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/state/{key}")
	public ResponseEntity<?> deleteState(@PathVariable String key) {
		try {
			String rs = stateService.deleteState(key);
			return new ResponseEntity<String>(rs, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in deleting the state of Key: " + key,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

package com.softtek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.model.StateData;
import com.softtek.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {

	@Autowired
	private StateService stateService;

	@PostMapping("save/{key}")
	public String setState(@PathVariable String key, @RequestBody StateData stateData) {
		String setState = stateService.setState(key, stateData);
		return setState;
	}

	@GetMapping("fetch/{key}")
	public StateData getState(@PathVariable String key) {
		return stateService.getState(key);
	}

	@DeleteMapping("delete/{key}")
	public String deleteState(@PathVariable String key) {
		String deleteState = stateService.deleteState(key);
		return deleteState;
	}
}

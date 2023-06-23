package com.softtek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.State;

@RestController
public class StateController {

	@Autowired
	private DaprClient daprClient;

	@PostMapping("/state/{key}")
	public String saveState(@PathVariable String key, @RequestBody String value) {
		daprClient.saveState("redis", key, value).block();
		return "Key: " + key + "State Saved successfully";
	}

	@GetMapping("/state/{key}")
	public String getState(@PathVariable String key) {
		State<String> state = daprClient.getState("redis", key, String.class).block();
		return state != null ? state.getValue() : null;
	}

	@DeleteMapping("/state/{key}")
	public String deleteState(@PathVariable String key) {
		daprClient.deleteState("redis", key).block();
		return "Key: " + key + " State Deleted successfully";
	}
}

package com.softtek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.State;

@Service
public class StateService {

	@Autowired
	private DaprClient daprClient;

	public String saveState(String key, String value) {
		daprClient.saveState("redis", key, value).block();
		return "Key: " + key + " of State is Saved successfully";
	}

	public String getState(String key) {
		State<String> state = daprClient.getState("redis", key, String.class).block();
		return state != null ? state.getValue() : "Key: " + key + " is not present!!";
	}

	public String deleteState(String key) {
		daprClient.deleteState("redis", key).block();
		return "Key: " + key + " of State is State Deleted successfully";
	}
}

package com.softtek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.model.StateData;
import com.softtek.repository.RedisRepository;

@Service
public class StateService {

	@Autowired
	private RedisRepository redisRepository;

	public StateData getState(String key) {
		Object state = redisRepository.findByKey(key);
		// Convert the state to StateData or perform any necessary transformations
		return (StateData) state;
	}

	public String setState(String key, StateData stateData) {
		redisRepository.save(key, stateData);
		return "State has been saved Successfully.....";
	}

	public String deleteState(String key) {
		redisRepository.delete(key);
		return "State has been deleted Successfully.....";
	}
}

package com.softtek.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public void save(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public Object findByKey(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public void delete(String key) {
		redisTemplate.delete(key);
	}
}

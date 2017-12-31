package com.kshrd.services;

import com.kshrd.models.User;

public interface UserService {
	public User findByUsername(String username);
}

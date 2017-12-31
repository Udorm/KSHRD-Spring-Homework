package com.kshrd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.models.User;
import com.kshrd.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

}

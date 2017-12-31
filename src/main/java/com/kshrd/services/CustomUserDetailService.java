package com.kshrd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kshrd.models.User;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	UserService userService;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		System.out.println(user);
		return new CustomUserDetail(user);
	}

}

package com.kshrd.repositories;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kshrd.models.User;

@Repository
public interface UserRepository {
	
	@Select("SELECT id, username, password FROM users WHERE username = #{username}")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "roles", column = "id", many = @Many(select = "com.kshrd.repositories.RoleRepository.findRolesByUserId"))
	})
	public User findUserByUsername(String username);
	
}

package com.kshrd.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kshrd.models.Role;

@Repository
public interface RoleRepository {
	@Select("select r.id, r.role from roles r")
	public List<Role> findAll();
	
	@Select("select r.id, r.role from roles r inner join user_role ur on r.id=ur.role_id where ur.user_id=#{id}")
	public List<Role> findRolesByUserId(int id);
}

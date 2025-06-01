package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	public Users findByUserId(Integer userId);
	
	public Users findByUserName(String userName);
	
}

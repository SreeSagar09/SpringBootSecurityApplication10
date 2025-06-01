package com.app.service;

import java.util.List;

import com.app.dto.UsersDTO;

public interface UserService {
	public UsersDTO getUserDetails(Integer userId);
	
	public List<UsersDTO> getAllUserDetails();
}

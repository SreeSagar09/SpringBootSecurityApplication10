package com.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UsersDTO;
import com.app.model.Users;
import com.app.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UsersDTO getUserDetails(Integer userId) {
		
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY");
			Users users = usersRepository.findByUserId(userId);
			
			UsersDTO.UsersDTOBuilder usersDTOBuilder = new UsersDTO.UsersDTOBuilder(users);
			
			usersDTOBuilder.setCreateDate(simpleDateFormat.format(users.getCreateDate()))
			.setUpdatedDate(simpleDateFormat.format(users.getUpdatedDate()));
			
			return usersDTOBuilder.build();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<UsersDTO> getAllUserDetails() {
		
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY");
			List<UsersDTO> usersDTOList = new LinkedList<>();
			
			List<Users> usersList = usersRepository.findAll();
			
			UsersDTO.UsersDTOBuilder usersDTOBuilder = null;
			for(Users users : usersList) {
				usersDTOBuilder = new UsersDTO.UsersDTOBuilder(users);
				
				usersDTOBuilder.setCreateDate(simpleDateFormat.format(users.getCreateDate()))
				.setUpdatedDate(simpleDateFormat.format(users.getUpdatedDate()));
				
				usersDTOList.add(usersDTOBuilder.build());
			}
			
			return usersDTOList;
		} catch (Exception e) {
			throw e;
		}
	}

}

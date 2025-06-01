package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.configuration.CustomUserDetails;
import com.app.model.Users;
import com.app.repository.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails customUserDetails = null;
		Users users = usersRepository.findByUserName(username);
		if(users != null) {
			customUserDetails = new CustomUserDetails(users);
		}else {
			customUserDetails = new CustomUserDetails(new Users());
		}
		
		return customUserDetails;
	}

}

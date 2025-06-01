package com.app.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.app.util.JWTServiceUtil;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
	private static JWTServiceUtil jwtServiceUtil = new JWTServiceUtil();
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Override
	public Map<String, Object> doAuthenticate(String username, String password) {
		
		Map<String, Object> responseMap = new LinkedHashMap<>();
		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			
			String accessToken = jwtServiceUtil.generateToken(userDetails);
			
			responseMap.put("accessToken", accessToken);
			return responseMap;
		} catch (Exception e) {
			throw e;
		}
	}

}

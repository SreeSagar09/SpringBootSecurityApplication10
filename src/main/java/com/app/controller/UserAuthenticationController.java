package com.app.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.UserAuthenticationService;

@RestController
@RequestMapping(path = "/authentication")
public class UserAuthenticationController {
	
	@Autowired
	private UserAuthenticationService usersAuthenticationService; 
	
	@PostMapping(path = "/doAuthenticate")
	public ResponseEntity<Map<String, Object>> doAuthenticate(@RequestBody Map<String, String> authDetails){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			Map<String, Object> errorsMap = new LinkedHashMap<>();
			
			String username = null;
			if(!authDetails.containsKey("username") || authDetails.get("username") == null 
					|| authDetails.get("username").trim().isEmpty()) {
				errorsMap.put("username", "Username is required.");
			}else {
				username = authDetails.get("username");
			}
			
			String password = null;
			if(!authDetails.containsKey("password") || authDetails.get("password") == null 
					|| authDetails.get("password").trim().isEmpty()) {
				errorsMap.put("password", "Password is required.");
			}else {
				password = authDetails.get("password");
			}
			
			if(errorsMap.isEmpty()) {
				Map<String, Object> responseMap = usersAuthenticationService.doAuthenticate(username, password);
					responseEntity = new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);
			}else {
				responseEntity = new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
			}
		}catch (BadCredentialsException e) {
			responseEntity = new ResponseEntity<>(Map.of("description", "Invalid username or password"), HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}

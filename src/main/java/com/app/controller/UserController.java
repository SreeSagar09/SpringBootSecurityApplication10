package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UsersDTO;
import com.app.model.Users;
import com.app.service.UserService;
import com.app.util.CommonUtil;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasAnyRole('Admin','User')")
	@GetMapping(path = "/userDetails")
	public ResponseEntity<Map<String, Object>> getUserDetails(){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			Users users = CommonUtil.getCurrentUser();
			
			UsersDTO usersDTO = userService.getUserDetails(users.getUserId());
			
			responseEntity = new ResponseEntity<>(Map.of("users", usersDTO), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PreAuthorize("hasRole('Admin')")
	@GetMapping(path = "/allUserDetails")
	public ResponseEntity<Map<String, Object>> getAllUserDetails(){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			List<UsersDTO> usersDTOList = userService.getAllUserDetails();
			
			responseEntity = new ResponseEntity<>(Map.of("usersList", usersDTOList), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
}

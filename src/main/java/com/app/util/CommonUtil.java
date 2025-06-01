package com.app.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.app.model.Users;

import com.app.configuration.CustomUserDetails;

public class CommonUtil {
	public static Users getCurrentUser() {
		Users users = null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null && authentication.isAuthenticated()) {
			Object object = authentication.getPrincipal();
			
			if(object instanceof CustomUserDetails) {
				users = ((CustomUserDetails) object).getUsers();
			}
		}
		
		return users;
	}
}

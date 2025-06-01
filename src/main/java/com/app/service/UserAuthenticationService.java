package com.app.service;

import java.util.Map;

public interface UserAuthenticationService {
	
	public Map<String, Object> doAuthenticate(String username, String password);
	
}

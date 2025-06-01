package com.app.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.util.JWTServiceUtil;

@Component
public class JwtTokenValidationFilter extends OncePerRequestFilter {
	private static JWTServiceUtil jwtServiceUtil = new JWTServiceUtil();
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorization = request.getHeader("Authorization");
		
		if(authorization != null && !authorization.trim().isEmpty()) {
			authorization = authorization.replace("Bearer ", "");
			
			String userName = jwtServiceUtil.extractUsername(authorization);
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(userName != null && !userName.trim().isEmpty() && authentication == null) {
				if(jwtServiceUtil.isTokenValid(authorization, userDetails)) {
					UsernamePasswordAuthenticationToken usersPasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					
					usersPasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usersPasswordAuthenticationToken);
				}
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
}

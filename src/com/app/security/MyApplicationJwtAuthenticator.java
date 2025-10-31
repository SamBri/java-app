package com.app.security;

import static com.app.dao.AbstractApplicationCursorDao.JDBC;

import org.springframework.security.core.userdetails.UserDetails;

import com.app.services.UserService;
import com.app.services.impl.UserServiceImpl;
import com.sun.net.httpserver.AbstractJwtUtil;
import com.sun.net.httpserver.JwtAuthenticator;

public class MyApplicationJwtAuthenticator extends JwtAuthenticator {
	
	private UserService userService;

	// JOOQ is the vendor
	{
		userService = new UserServiceImpl(JDBC); // JDBC.
	}

	public MyApplicationJwtAuthenticator(AbstractJwtUtil jwtUtil) {
		super(jwtUtil);
	}

	@Override
	public boolean checkCredentials(String username) {
		
		UserDetails userDetails = userService.loadUserByUsername(username);
		
		
		if(null == userDetails) {
			return false;
		}
		
		return true;
	}

}

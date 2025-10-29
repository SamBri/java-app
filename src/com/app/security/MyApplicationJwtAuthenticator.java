package com.app.security;

import com.sun.net.httpserver.AbstractJwtUtil;
import com.sun.net.httpserver.JwtAuthenticator;

public class MyApplicationJwtAuthenticator extends JwtAuthenticator {

	public MyApplicationJwtAuthenticator(AbstractJwtUtil jwtUtil) {
		super(jwtUtil);
	}

	@Override
	public boolean checkCredentials(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}

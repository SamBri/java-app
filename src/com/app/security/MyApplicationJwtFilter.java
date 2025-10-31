package com.app.security;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import sun.net.httpserver.AuthFilter;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;

public class MyApplicationJwtFilter extends AuthFilter {

    public MyApplicationJwtFilter(Authenticator authenticator) {
		super(authenticator);
	}

	@Override
	public void doFilter(HttpExchange t, Chain chain) throws IOException {
		
		
		if(!t.getRequestURI().toString().startsWith("/auth"))
		{
			
			super.doFilter(t, chain);

		}else {
			chain.doFilter(t);
		}
		
	}
    
    
 

}
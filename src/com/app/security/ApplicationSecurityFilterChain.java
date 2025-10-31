package com.app.security;

import java.io.IOException;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;

public class ApplicationSecurityFilterChain extends Filter {

	
	@Override
	public void doFilter(HttpExchange exchange, Chain chain) throws IOException {
		if(!exchange.getHttpContext().toString().startsWith("/")) {
			System.out.println("@@@@@@@");
			chain.doFilter(exchange);
		}
	}

	@Override
	public String description() {
		return ApplicationSecurityFilterChain.class.getName();
	}

}



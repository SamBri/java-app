package com.app.controllers;

import static com.app.dao.AbstractApplicationCursorDao.JDBC;

import java.io.IOException;
import java.io.OutputStream;

import com.app.services.UserService;
import com.app.services.impl.UserServiceImpl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

// /reliable/cursors
// /reliable/cursors
public class UsersControllerHandlerImpl implements HttpHandler {
	
	
	private UserService userService;

	// JOOQ is the vendor
	{
		userService = new UserServiceImpl(JDBC); // JDBC.
	}


	@Override
	public void handle(HttpExchange exchange) throws IOException {

		//

		System.out.println("exchange request method:" + exchange.getRequestMethod());
		System.out.println("exchange request path:" + exchange.getRequestURI());

		String response = "This is the response from the server.";
		exchange.sendResponseHeaders(200, response.length());
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

}

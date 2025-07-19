package com.app.controllers;

import org.jooq.Result;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jooq.Record;

import com.app.dao.impl.jooq.ApplicationCursorDaoImpl;
import com.app.dto.AppCursorDto;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

// /reliable/cursors
// /reliable/cursors
public class UsersControllerHandlerImpl implements HttpHandler {

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

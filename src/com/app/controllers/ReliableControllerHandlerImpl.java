package com.app.controllers;

import org.jooq.Result;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jooq.Record;

import com.app.dao.ApplicationCursorDao;
import com.app.dto.AppCursorDto;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

// /reliable/cursors
// /reliable/cursors
public class ReliableControllerHandlerImpl implements HttpHandler {

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

	// fetch all app cursors.
	public static List<?> fetchCursors() {

		Result<Record> cursors = new ApplicationCursorDao().fetchCursors();

		return cursors;

	}

	// create cursor
	public static int createCursor(AppCursorDto dto) {

		return new ApplicationCursorDao().createCursor(dto);

	}

	public static void main(String[] args) {

		// System.out.println(fetchCursors()); // read cursors.

		AppCursorDto dto1 = new AppCursorDto();
		dto1.setName("eclipse");
		dto1.setNonce("single-command");
		dto1.setPosX(10);
		dto1.setPosY(20);
		System.out.println(createCursor(dto1)); // create cursors;

		AppCursorDto dto2 = new AppCursorDto();
		dto2.setName("wordpad");
		dto2.setNonce("multiple-command");
		dto2.setPosX(1);
		dto2.setPosY(100);
		System.out.println(createCursor(dto2)); // create cursors;

		System.out.println(fetchCursors()); // read cursors.

	}

}

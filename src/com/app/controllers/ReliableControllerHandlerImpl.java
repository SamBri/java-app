package com.app.controllers;

import org.jooq.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jooq.Record;

import com.app.dao.ApplicationCursorDao;
import com.app.dto.AppCursorDto;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

// /reliable/cursors - Create Cursors | POST
// /reliable/cursors - Fetch All Cursors | GET
// /reliable/cursors/:cursorId - Fetch Cursor by cursorId | GET
// /reliable/cursors/:cursorId - Update Cursor | PUT
// /reliable/cursors/:cursorId - Delete cursor | DELETE 
///reliable/cursors/trash - check cursors bin.

///reliable/builds - Create Cursors | POST
///reliable/builds - Fetch All Cursors | GET
///reliable/builds/:buildId - Fetch Cursor by cursorId | GET
///reliable/builds/:buildId - Update Cursor | PUT
///reliable/builds/:buildId - Delete cursor | DELETE 
public class ReliableControllerHandlerImpl implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		System.out.println("exchange request method:" + exchange.getRequestMethod());
		System.out.println("exchange request path:" + exchange.getRequestURI());

		String service = exchange.getRequestURI().getPath().replace("/api", ""); // remove the root for service
																					// selection
		String method = exchange.getRequestMethod();
		String endpoint = null;

		StringBuilder requestPayload = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))) {

			String str = null;
			requestPayload = new StringBuilder();
			while ((str = br.readLine()) != null) {
				requestPayload.append(str);
			}
		} catch (Exception e) {

		}

		String response = null;
		// cursor service
		if (service.startsWith("/cursors")) {

			// at which endpoint.
			endpoint = service;

			switch (endpoint) {

			// /cursors - Create Cursors | POST
			// /cursors - Fetch All Cursors | GET
			case "/cursors": {
				response = switch (method) {

				case "POST": {
					// string to json.
					System.out.println(requestPayload);
					AppCursorDto dto1 = new AppCursorDto();
					yield String.valueOf(createCursor(dto1));
				}
				case "GET": {
					yield fetchCursors().toString();
				}
				case "PUT": {
					yield null;
				}
				case "PATCH": {
					yield null;
				}
				case "DELETE": {
					yield null;
				}

				default: {
					yield null;
				}

				};
			}
				break;

			case "/cursors/:cursorId": {
				switch (method) {

				case "POST":
					break;
				case "GET":
					break;
				case "PUT":
					break;
				case "PATCH":
					break;
				case "DELETE":
					break;

				}
			}
				break;

			}

		}

		// build
		if (service.startsWith("builds")) {

			switch (endpoint) {

			// /builds - Create Cursors | POST
			// /cursors - Fetch All Cursors | GET
			case "/builds": {
				switch (method) {

				case "POST":
					break;
				case "GET":
					break;
				case "PUT":
					break;
				case "PATCH":
					break;
				case "DELETE":
					break;

				}
			}
				break;

			case "/builds/:buildId": {
				switch (method) {

				case "POST":
					break;
				case "GET":
					break;
				case "PUT":
					break;
				case "PATCH":
					break;
				case "DELETE":
					break;

				}
			}
				break;

			}

		}

		// String response = "This is the response from the server.";
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

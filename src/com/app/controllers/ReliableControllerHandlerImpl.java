package com.app.controllers;

import static com.app.dao.AbstractApplicationCursorDao.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.app.dto.AppCursorDto;
import com.app.services.ApplicationCursorService;
import com.app.services.impl.ApplicationCursorServiceImpl;
import com.google.gson.Gson;
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

//	private ApplicationCursorDao cursorDao;
	private ApplicationCursorService cursorServices;

	// JOOQ is the vendor
	{
		cursorServices = new ApplicationCursorServiceImpl(JOOQ); // JDBC.
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		System.out.println("exchange request method:" + exchange.getRequestMethod());
		System.out.println("exchange request path:" + exchange.getRequestURI());
		System.out.println("exchange request headers:" + exchange.getRequestHeaders().toString());

		// String service = exchange.getRequestURI().getPath().replace("/api/reliable",
		// ""); // remove the root for service

		String serviceUrl = exchange.getServiceUrl();
		String service = serviceUrl.replace("/reliable", "");
		
		

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
			Gson cursorsJson = null;

			switch (endpoint) {

			// /cursors - Create Cursors | POST
			// /cursors - Fetch All Cursors | GET
			case "/cursors": {
				response = switch (method) {

				case "POST": {
					// string to json.
					// cursorServices = new ApplicationCursorServiceImpl(); // a new service call
					System.out.println("req:" + requestPayload);
					AppCursorDto dto1 = new AppCursorDto();
					cursorsJson = new Gson();
					dto1 = cursorsJson.fromJson(requestPayload.toString(), AppCursorDto.class);
					System.out.println("dto:" + dto1);
					exchange.getResponseHeaders().rawAdd("Content-Type", "application/json");
					exchange.sendResponseHeaders(201, dto1.toString().length());
					yield cursorServices.createCursor(dto1);
				}
				case "GET": {

					// cursorServices = new ApplicationCursorServiceImpl(); // a new service call
					cursorsJson = new Gson();
					String str = cursorsJson.toJson(cursorServices.fetchCursors());
					exchange.getResponseHeaders().rawAdd("Content-Type", "application/json");
					exchange.sendResponseHeaders(200, str.length());
					yield str;
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
			case "/cursors/*": {
				response = switch (method) {

				case "POST": {

				}
				case "GET": {
					String rawServiceUrl = exchange.getRawServiceUrl();
					System.out.println("@@ rawServiceUrl:"+rawServiceUrl);
					

					// extract params.
					// /cursors/*
				    String cursorId = (String) exchange.params().stream().limit(1).findAny().get();

					// cursorServices = new ApplicationCursorServiceImpl(); // a new service call
					cursorsJson = new Gson();
					String str = cursorsJson.toJson(cursorServices.fetchCursor(cursorId));
					exchange.getResponseHeaders().rawAdd("Content-Type", "application/json");
					exchange.sendResponseHeaders(200, str.length());
					yield str;
				}
				case "PUT": {

				}
				case "PATCH": {

				}
				case "DELETE": {

				}
				default:
					yield null;

				};
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

			case "/builds/*": {
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

		OutputStream os = exchange.getResponseBody();
		System.out.println("response headers ::" + exchange.getResponseHeaders());
		os.write(response.getBytes());
		os.close();
	}

}

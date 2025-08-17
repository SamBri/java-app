package com.app.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import com.app.dto.AppCursorDto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class JsonControllerHandlerImpl implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		//

		
		System.out.println("exchange request method:" + exchange.getRequestMethod());
		System.out.println("exchange request path:" + exchange.getRequestURI());

		String response = "This is the response from the server.";
		System.out.println("str:");

		
		if(exchange.getRequestMethod().equalsIgnoreCase("GET")) {

			// read constants from json file.
			JsonElement codes_file = null;
			JsonObject codes_file_jsonObject = null;
			
			// poor io, performance , resource leaks and security vunerability
			codes_file = JsonParser.parseReader(new FileReader("codes.json"));
			codes_file_jsonObject = codes_file.getAsJsonObject();
			
		// improved io operations, resource leaks - memory consumptions	
//			try (BufferedReader br = new BufferedReader(new FileReader("codes.json"))) {
//				codes_file = JsonParser.parseReader(br);
//				codes_file_jsonObject = codes_file.getAsJsonObject();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

		
			
			String controllerResponse = """
					{
					 "message":{message},
					 "description":{description},
					 "quality":"{quality}"
					}
					"""
					.replace("{message}", codes_file_jsonObject.get("200").getAsJsonObject().get("message").toString())
					.replace("{description}", codes_file_jsonObject.get("200").getAsJsonObject().get("description").toString())
					.replace("{quality}", "LOW");


			System.out.println("str:"+controllerResponse);
			response = controllerResponse;
			exchange.getResponseHeaders().rawAdd("Content-Type", "application/json");
			exchange.sendResponseHeaders(200, controllerResponse.length());
			
		}
		
		
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

}
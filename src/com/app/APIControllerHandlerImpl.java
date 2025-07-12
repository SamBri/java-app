package com.app;

import java.io.IOException;
import java.net.URI;

import com.app.controllers.ReliableControllerHandlerImpl;
import com.app.controllers.UsersControllerHandlerImpl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

//api
public class APIControllerHandlerImpl implements HttpHandler {


	@Override
	public void handle(HttpExchange exchange) throws IOException {

		URI requestUri = exchange.getRequestURI();
		System.out.println(requestUri.toString());

	//	String path = PathUtils.canonicalise(requestUri, "/api");

		String serviceUrl = exchange.getServiceUrl();
		
		System.out.println(exchange.getRequestURI());

		HttpHandler handler = null;

		handler = switch (serviceUrl) {
		case "/reliable/cursors":
		case "/reliable/cursors/*": {
			handler = new ReliableControllerHandlerImpl();
			yield handler;
		}
		case "/users": {
			handler = new UsersControllerHandlerImpl();
			yield handler;
		}
		default:
			throw new UnsupportedOperationException("Handler not found : " + serviceUrl);
		};

		handler.handle(exchange);

	}

	public static void main(String[] args) {
	//	System.out.println(PathUtils.canonicalise(URI.create("/api/reliable/cursors/test"), "/api"));
	
	//	System.out.println(PathUtils.canonicalise(URI.create("/api/reliable/cursors/"), "/api"));

	}

}

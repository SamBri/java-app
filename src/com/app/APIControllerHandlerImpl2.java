package com.app;

import java.io.IOException;
import java.net.URI;

import com.app.controllers.ReliableControllerHandlerImpl;
import com.app.controllers.UsersControllerHandlerImpl;
import com.app.security.AuthenticationController;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

//api
public class APIControllerHandlerImpl2 implements HttpHandler {

	// target end user - corporation.
	// Fast, Secure, RELIABLE. - 100000000 . base customers.

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		URI requestUri = exchange.getRequestURI();
		System.out.println(requestUri.toString());
		System.out.println("exchange request @ headers:" + exchange.getRequestHeaders().toString());


		String serviceUrl = exchange.getRawServiceUrl();
		
		System.out.println(serviceUrl);
		System.out.println(exchange.getRequestURI());

		serviceUrl = serviceUrl.replace("/api", "");

		HttpHandler handler = null;
		
		if(exchange.getRequestURI().toString().startsWith("/auth")) {
			handler = new AuthenticationController();
		}else {
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
		}



		handler.handle(exchange);

	}

	public static void main(String[] args) {

	}

}

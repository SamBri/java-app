package com.app;

import java.io.IOException;
import java.net.URI;

import com.app.controllers.ReliableControllerHandlerImpl;
import com.app.controllers.UsersControllerHandlerImpl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

//api
public class APIControllerHandlerImpl implements HttpHandler {

	enum Services {
		RELIABLE, USERS;

		static Services asService(String path) {
			path = path.replace("/", "");
			return Services.valueOf(path);

		}

		static Services asService(URI uri, String root) {
			String path = uri.getPath().replace(root, "");
			path = path.replace("/", "");
			return Services.valueOf(String.format("%S", path));

		}

	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		URI requestUri = exchange.getRequestURI();
		System.out.println(requestUri.toString());

		Services service = requestUri.getPath().startsWith("/api") ? Services.asService(requestUri, "/api") : null;
		System.out.println(exchange.getRequestURI());

		HttpHandler handler = null;

		handler = switch (service) {
		case RELIABLE: {
			handler = new ReliableControllerHandlerImpl();
			yield handler;
		}
		case USERS: {
			handler = new UsersControllerHandlerImpl();
			yield handler;
		}
		default:
			throw new UnsupportedOperationException("Handler not found : " + service);
		};

		handler.handle(exchange);

	}

}

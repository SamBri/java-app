package com.app;

import java.io.IOException;
import java.net.URI;

import com.app.controllers.ReliableControllerHandlerImpl;
import com.app.controllers.UsersControllerHandlerImpl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

//api
public class APIControllerHandlerImpl implements HttpHandler {

	class PathUtils {

		static String canonicalise(URI uri, String root) {
			String path = uri.getPath().replace(root, "");
			return path;
		}

	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		URI requestUri = exchange.getRequestURI();
		System.out.println(requestUri.toString());

		String path = PathUtils.canonicalise(requestUri, "/api");

		System.out.println(exchange.getRequestURI());

		HttpHandler handler = null;

		handler = switch (path) {
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
			throw new UnsupportedOperationException("Handler not found : " + path);
		};

		handler.handle(exchange);

	}

}

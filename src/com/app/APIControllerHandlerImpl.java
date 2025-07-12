package com.app;

import java.io.IOException;
import java.net.URI;

import com.app.controllers.ReliableControllerHandlerImpl;
import com.app.controllers.UsersControllerHandlerImpl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

//api
public class APIControllerHandlerImpl implements HttpHandler {

	// a member.
	class PathUtils {

		static String canonicalise(URI uri, String root) {
			String path = uri.getPath().replace(root, "");
			path = prioritize(path);
			return path;
		}

		static String prioritize(String path) {

			// void test(T t);

			for (int i = 0, slash = 0; i < path.length(); i++) {

				if (path.charAt(i) == '/') {
					slash++;
				}

				if (slash == 3) {

					return path.replace(path.substring(i), "/*");
				}
			}

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

	public static void main(String[] args) {
		System.out.println(PathUtils.canonicalise(URI.create("/api/reliable/cursors/test"), "/api"));
	
		System.out.println(PathUtils.canonicalise(URI.create("/api/reliable/cursors/"), "/api"));

	}

}

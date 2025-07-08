package com.app.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.app.controllers.ReliableControllerHandlerImpl;
import com.app.controllers.APIControllerHandlerImpl;
import com.sun.net.httpserver.HttpServer;




public class Server {

	

	public static void main(String[] args) throws IOException {
	
		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
       // server.createContext("/test", new ReliableControllerHandlerImpl());
        server.createContext("/api", new APIControllerHandlerImpl());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8001");

	}
	


}

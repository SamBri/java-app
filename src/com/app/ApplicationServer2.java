package com.app;


import java.io.IOException;
import java.net.InetSocketAddress;

import com.app.security.MyApplicationJwtFilter;
import com.app.security.MyApplicationJwtUtil;
import com.app.security.MyApplicationJwtAuthenticator;
import com.sun.net.httpserver.HttpServer;


public class ApplicationServer2 {



	public static void main(String[] args) throws IOException {
	
		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.create(new InetSocketAddress("localhost", 8001), 0, "/api",  new APIControllerHandlerImpl2(), new MyApplicationJwtFilter(new MyApplicationJwtAuthenticator(new MyApplicationJwtUtil()))); 
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8001");

	}
	

}

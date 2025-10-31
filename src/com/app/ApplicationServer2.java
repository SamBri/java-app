package com.app;


import java.io.IOException;
import java.net.InetSocketAddress;

import com.app.security.ApplicationSecurityFilterChain;
import com.app.security.MyApplicationJwtAuthenticator;
import com.app.security.MyApplicationJwtFilter;
import com.app.security.MyApplicationJwtUtil;
import com.sun.net.httpserver.HttpServer;

//import com.sun.net.httpserver.HttpServer;


public class ApplicationServer2 {

//TODO:
	// 1. expired jwt handling
	// 2. dynamic path handling.
	
	// issues 
	// 1. mysql client server ssl communication.

	public static void main(String[] args) throws IOException {
	
		int port = 8002;
		MyApplicationJwtUtil appJwtUtil = new MyApplicationJwtUtil();
		MyApplicationJwtAuthenticator jwtAuthenticator = new MyApplicationJwtAuthenticator(appJwtUtil);
		MyApplicationJwtFilter jwtFilter = new MyApplicationJwtFilter(jwtAuthenticator);
        HttpServer server =  HttpServer.create(new InetSocketAddress("localhost", 8002), 0, "/",  new APIControllerHandlerImpl2(), jwtFilter); 
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port " + port);

	}
	

}

package com.app;


import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;






public class ApplicationServer2 {

	


	public static void main(String[] args) throws IOException {
	
		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
       
		server.createContext("/", new APIControllerHandlerImpl2() );
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8001");

	}
	

}

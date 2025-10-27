package com.app;


import java.io.IOException;
import java.net.InetSocketAddress;

import com.app.security.ApplicationSecurityConfiguration;
import com.sun.net.httpserver.HttpServer;


public class ApplicationServer2 {



	public static void main(String[] args) throws IOException {
	
		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
       //	server.createContext("/api", new APIControllerHandlerImpl2() );
		// insert spring security filters on server start
        //	server.create(null, 0, null, null, new ApplicationSecurityConfiguration().securityFilterChain(null)); 
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8001");

	}
	

}

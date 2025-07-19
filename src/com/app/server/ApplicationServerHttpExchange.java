package com.app.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;

public class ApplicationServerHttpExchange extends HttpExchange{

	@Override
	public Headers getRequestHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Headers getResponseHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getRequestURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpContext getHttpContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InputStream getRequestBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputStream getResponseBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendResponseHeaders(int rCode, long responseLength) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InetSocketAddress getRemoteAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getResponseCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InetSocketAddress getLocalAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStreams(InputStream i, OutputStream o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HttpPrincipal getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.app.security;

import static com.app.dao.AbstractApplicationCursorDao.JDBC;
import static org.springframework.security.core.userdetails.User.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import org.springframework.security.core.userdetails.UserDetails;

import com.app.ApplicationResponseSchema;
import com.app.dto.AppCursorDto;
import com.app.entity.User;
import com.app.services.UserService;
import com.app.services.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

// API security
public class AuthenticationController implements HttpHandler {

	static BCryptPasswordEncoder passwordEncoder;

	private MyApplicationJwtUtil appJwtUtil;

	private UserService userService;

	{
		userService = new UserServiceImpl(JDBC); // JDBC.
		passwordEncoder = new BCryptPasswordEncoder();
		appJwtUtil = new MyApplicationJwtUtil();
	}

	public AuthenticationController(MyApplicationJwtUtil appJwtUtil, UserService userService) {
		this.appJwtUtil = appJwtUtil;
		this.userService = userService;
	}

	public AuthenticationController() {
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub
		

		System.out.println("auth url" + exchange.getRequestURI());
		
		StringBuilder requestPayload = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))) {

			String str = null;
			requestPayload = new StringBuilder();
			while ((str = br.readLine()) != null) {
				requestPayload.append(str);
			}
		} catch (Exception e) {

		}

		ApplicationResponseSchema<? extends Object> responseSchema = null;
		String responseJson = null;
		if (exchange.getRequestURI().toString().contains("signup")) {
			
			User user = new User();
			Gson userJson = new Gson();
			user = userJson.fromJson(requestPayload.toString(), User.class);
			System.out.println("user:" + user);
			
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			responseSchema = doUserSignup(user);
			
			if(responseSchema.getStatus().equalsIgnoreCase("success")) {
				
				responseSchema.setData(null);
				responseJson = userJson.toJson(responseSchema);
			}else {
				responseSchema.setData(null);
				responseJson = userJson.toJson(responseSchema);
			}		

			exchange.getResponseHeaders().rawAdd("Content-Type", "application/json");
			exchange.sendResponseHeaders(201, responseJson.toString().length());
			

		}else if (exchange.getRequestURI().toString().contains("login")) {
			User user = new User();
			Gson userJson = new Gson();
			user = userJson.fromJson(requestPayload.toString(), User.class);
			System.out.println("user:" + user);
			
			responseSchema = authenticateUser(user);
			
			
			if(responseSchema.getStatus().equalsIgnoreCase("success")) {
				
				//responseSchema.setData(null);

				responseJson = userJson.toJson(responseSchema);
			}else {
				responseSchema.setData(null);

				responseJson = userJson.toJson(responseSchema);
			}
					

			System.out.println("dto:" + responseSchema);

			exchange.getResponseHeaders().rawAdd("Content-Type", "application/json");
			exchange.sendResponseHeaders(201, responseJson.toString().length());
			
		}else {
			
		}
		
		
		OutputStream os = exchange.getResponseBody();
		System.out.println("response headers ::" + exchange.getResponseHeaders());
		os.write(responseJson.toString().getBytes());
		os.close();

	}

	private ApplicationResponseSchema<User> doUserSignup(User user) {
		ApplicationResponseSchema<User> appResponseSchema = null;

		UserDetails userDetail = userService.loadUserByUsername(user.getUsername());
		// check profile exists
		if (userDetail != null) {
			appResponseSchema = new ApplicationResponseSchema<>();
			appResponseSchema.setCode(500);
			appResponseSchema.setStatus("failed");
			appResponseSchema.setData(null);
			appResponseSchema.setMessage("signup failed. duplicate profile.");
			return appResponseSchema;
		}

		User theCreatedUser = userService.createUser(user);

		if (theCreatedUser != null) {
			appResponseSchema = new ApplicationResponseSchema<>();
			appResponseSchema.setCode(200);
			appResponseSchema.setStatus("success");
			appResponseSchema.setData(theCreatedUser);
			appResponseSchema.setMessage("user signup was successful.");
		} else {
			appResponseSchema = new ApplicationResponseSchema<>();
			appResponseSchema.setCode(500);
			appResponseSchema.setData(theCreatedUser);
			appResponseSchema.setMessage("user signup failed.");
		}

		return appResponseSchema;

	}

	private ApplicationResponseSchema<String> authenticateUser(User user) {

		UserDetails userDetail = builder().username(user.getUsername()).password(user.getPassword()).build();

		// valid user exist
		userDetail = userService.loadUserByUsername(user.getUsername());
		if (userDetail == null) {
			ApplicationResponseSchema<String> ApplicationResponseSchema = new ApplicationResponseSchema<>();
			ApplicationResponseSchema.setCode(500);
			ApplicationResponseSchema.setStatus("failed");
			ApplicationResponseSchema.setData("user account not found");
			ApplicationResponseSchema.setMessage("user token generated failed!");
			return ApplicationResponseSchema;
		}

		// invalid credentials
		if (!passwordEncoder.matches(user.getPassword(), userDetail.getPassword())) {
			ApplicationResponseSchema<String> appResponseSchema = new ApplicationResponseSchema<>();
			appResponseSchema.setCode(500);
			appResponseSchema.setStatus("failed");
			appResponseSchema.setData("invalid user credentials");
			appResponseSchema.setMessage("user token generated failed!");
			return appResponseSchema;
		}

		String token = appJwtUtil.generateToken(userDetail);
		ApplicationResponseSchema<String> appResponseSchema = new ApplicationResponseSchema<>();
		appResponseSchema.setCode(200);
		appResponseSchema.setStatus("success");
		appResponseSchema.setData(token);
		appResponseSchema.setMessage("user token generated successfully");

		return appResponseSchema;

	}

}

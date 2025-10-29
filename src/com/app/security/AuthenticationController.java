package com.app.security;


import static com.app.dao.AbstractApplicationCursorDao.JDBC;
import static com.app.security.ApplicationSecurityConfiguration.passwordEncoder;
import static org.springframework.security.core.userdetails.User.builder;

import org.springframework.security.core.userdetails.UserDetails;

import com.app.ApplicationResponseSchema;
import com.app.entity.User;
import com.app.services.UserService;
import com.app.services.impl.UserServiceImpl;


// API security
public class AuthenticationController {
	
	
	private MyApplicationJwtUtil appJwtUtil;
	
	private UserService userService;
	

	{
		userService = new  UserServiceImpl(JDBC); // JDBC.
	}
	
	public AuthenticationController(MyApplicationJwtUtil appJwtUtil, UserService userService) {
		this.appJwtUtil = appJwtUtil;
		this.userService = userService;
	}


	public ApplicationResponseSchema<User> doUserSignup( User user) {
		ApplicationResponseSchema<User> appResponseSchema = null;
		   	

			UserDetails userDetail = null;
			//check profile exists
			  if(userDetail != null) {
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

	
	
	
	public ApplicationResponseSchema<String> authenticateUser( User user) {
		
		UserDetails userDetail = builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.build();
		
		// valid user exist
		   userDetail =	userService.loadUserByUsername(user.getUsername());
		   if(userDetail == null) {
			   ApplicationResponseSchema<String>	ApplicationResponseSchema = new ApplicationResponseSchema<>();
				ApplicationResponseSchema.setCode(500);
				ApplicationResponseSchema.setStatus("failed");
				ApplicationResponseSchema.setData("user account not found");
				ApplicationResponseSchema.setMessage("user token generated failed!");
				return ApplicationResponseSchema;
		   }
	   	
		// invalid credentials   
	   if(!passwordEncoder().matches(user.getPassword(), userDetail.getPassword())) {
		   ApplicationResponseSchema<String>	appResponseSchema = new ApplicationResponseSchema<>();
		   appResponseSchema.setCode(500);
			appResponseSchema.setStatus("failed");
			appResponseSchema.setData("invalid user credentials");
			appResponseSchema.setMessage("user token generated failed!");
			return appResponseSchema;
	   }

		String token = appJwtUtil.generateToken(userDetail);
	    ApplicationResponseSchema<String>	appResponseSchema = new ApplicationResponseSchema<>();
	    appResponseSchema.setCode(200);
	    appResponseSchema.setStatus("success");
		appResponseSchema.setData(token);
		appResponseSchema.setMessage("user token generated successfully");
		
		return appResponseSchema;
		
		
	}
	
	
	
	
	
}

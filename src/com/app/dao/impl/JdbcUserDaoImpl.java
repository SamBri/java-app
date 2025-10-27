package com.app.dao.impl;

import static org.springframework.security.core.userdetails.User.builder;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.dao.AbstractUserDao;


public class JdbcUserDaoImpl extends AbstractUserDao  {
	
	
	private PasswordEncoder passwordEncoder;

	
	private String userName = "root";
	private String password = "BlueObjectx1"; // change as you want
	private String url = "jdbc:mysql://localhost:3306/java_app";

// make a db connection.
	public Connection getConnection() {

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			// System.setProperty("javax.net.ssl.keyStore","C:\\ProgramData\\MySQL\\MySQL
			// Server 8.0\\Data\\keystore");
			// System.setProperty("javax.net.ssl.keyStorePassword",password);

			Connection conn = DriverManager.getConnection(url, userName, password);
			return conn;
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserById(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

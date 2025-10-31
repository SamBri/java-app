package com.app.dao.impl;

import static org.springframework.security.core.userdetails.User.builder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.dao.AbstractUserDao;
import com.app.entity.User;


public class JdbcUserDaoImpl extends AbstractUserDao  {
	
	
	private PasswordEncoder passwordEncoder;

	
	private String userName = "root";
	private String password = "BlueObjectx1"; // change as you want
	private String url = "jdbc:mysql://localhost:3306/java_app?enabledTLSProtocols=TLSv1.2";

// make a db connection.
	public Connection getConnection() {

		try {
	
			Connection conn = DriverManager.getConnection(url, userName, password);
			return conn;
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	@Override
	public User createUser(User user) {

		String createUserQuery = """
				INSERT INTO users
				(username,
				password) values ({username}, {password});
				""";

		createUserQuery = createUserQuery.replace("{username}", "\""+user.getUsername()+"\"")
				.replace("{password}","\""+user.getPassword()+"\"");
		
		System.out.println(createUserQuery);
				
		int q = 0;
		try (Connection createUserConn = getConnection()) {

			Statement stmt = createUserConn.createStatement();
			q = stmt.executeUpdate(createUserQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (q != 1) {

			return null;
		}
		
		
		return user;	
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int i) {

		return null;
	}

	@Override
	public User updateUser(int userId) {
		return null;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 UserDetails userDetail = null;

			String selectUserByUsernameQuery = """
					SELECT username, password FROM users u WHERE u.username = {username};
					""";

			selectUserByUsernameQuery = selectUserByUsernameQuery.replace("{username}", "\""+username+"\"");
			
			System.out.println(selectUserByUsernameQuery);
					
			ResultSet rs = null;
			try (Connection createUserConn = getConnection()) {

				Statement stmt = createUserConn.createStatement();
				rs = stmt.executeQuery(selectUserByUsernameQuery);
				
				while(rs.next()) {
					
				    username = rs.getString("username");
			        String password = rs.getString("password");
			        
					 userDetail = builder().username(username).password(password).build();
			     
					
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			if(userDetail != null) {
				return userDetail;
			}
			
		
	
	
		 return null;
	}

}

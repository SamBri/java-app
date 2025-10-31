package com.app.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.entity.User;

public abstract class AbstractUserDao implements UserDetailsService {
	
	public final static int JOOQ = 1;
	public final static int JPA = 2;
	public final static int HIBERNATE = 3;
	public final static int MOET = 4;
	public final static int JDBC = 5;

	public abstract User createUser(User user);

	public abstract List<User> getUsers();

	public abstract User getUserById(int i);

	public abstract User updateUser(int userId);

	public abstract void deleteUser(int userId);


}

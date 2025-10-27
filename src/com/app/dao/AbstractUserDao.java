package com.app.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.dto.AppCursorDto;

public abstract class AbstractUserDao implements UserDetailsService {
	
	public final static int JOOQ = 1;
	public final static int JPA = 2;
	public final static int HIBERNATE = 3;
	public final static int MOET = 4;
	public final static int JDBC = 5;

	public abstract void createUser();

	public abstract void getUsers();

	public abstract void getUserById(int i);

	public abstract void updateUser(int userId);

	public abstract void deleteUser(int userId);


}

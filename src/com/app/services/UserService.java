package com.app.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.entity.User;

public interface UserService {
	

	User createUser(User user);

	List<User> getUsers();

	User getUserById(int i);

	User updateUser(int userId);

	void deleteUser(int userId);
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	

}

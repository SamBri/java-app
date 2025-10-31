package com.app.services.impl;

import static com.app.dao.AbstractApplicationCursorDao.JDBC;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.dao.AbstractUserDao;
import com.app.dao.impl.JdbcUserDaoImpl;
import com.app.entity.User;
import com.app.services.UserService;

public class UserServiceImpl implements UserService {


	private AbstractUserDao abstractDao;


	public UserServiceImpl(int id) {
		this.abstractDao = switch (id) {

		case JDBC:
			yield new JdbcUserDaoImpl();
		default:
			yield null;

		};
	}

	@Override
	public User createUser(User user) {

		user =	this.abstractDao.createUser(user);
		return user;
	}

	@Override
	public List<User> getUsers() {
     return this.abstractDao.getUsers();
	}

	@Override
	public User getUserById(int i) {
     return this.abstractDao.getUserById(i);
	}

	@Override
	public User updateUser(int userId) {
    return this.abstractDao.updateUser(userId);
	}

	@Override
	public void deleteUser(int userId) {

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		return abstractDao.loadUserByUsername(username);
	}

}

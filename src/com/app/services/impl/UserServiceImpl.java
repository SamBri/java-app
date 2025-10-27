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
		// TODO Auto-generated method stub
    return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
     return null;
	}

	@Override
	public User getUserById(int i) {
		// TODO Auto-generated method stub
     return null;
	}

	@Override
	public User updateUser(int userId) {
		// TODO Auto-generated method stub
 return null;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return abstractDao.loadUserByUsername(username);
	}

}

package com.project.service.impl;

import java.util.List;

import com.project.dao.UserDao;
import com.project.dao.impl.UserDaoImpl;
import com.project.dto.UserDTO;
import com.project.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean saveUser(UserDTO user) {
		// TODO Auto-generated method stub
//		System.out.println("In Service Layer");
//		System.out.println(user);
		boolean b = userDao.saveUser(user);
		return b;
	}

	@Override
	public boolean updateUser(UserDTO user) {
		// TODO Auto-generated method stub
		boolean b = userDao.updateUser(user);
		return b;
	}

	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		boolean b = userDao.deleteUser(email);
		return b;
	}

	@Override
	public boolean searchUser(String email) {
		// TODO Auto-generated method stub
		boolean b = userDao.searchUser(email);
		return b;
	}

	@Override
	public List<UserDTO> showAllUser() {
		// TODO Auto-generated method stub
		List<UserDTO> b = userDao.showAllUser();
		return b;
	}

}

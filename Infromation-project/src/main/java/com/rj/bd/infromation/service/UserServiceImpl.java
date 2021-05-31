package com.rj.bd.infromation.service;

import java.util.List;

import com.rj.bd.infromation.dao.UserDao;
import com.rj.bd.infromation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl  implements  IUserService{

@Autowired
public UserDao userDao;
	
	
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	@Transactional
	public void UpdateUser(User user) {
		userDao.UpdateUser(user);
	}

	@Transactional
	public void InsertUser(User user) {
		userDao.InsertUser(user);
	}

	@Transactional
	public void DeleteUser(String id) {
		userDao.DeleteUser(id);
	}

}

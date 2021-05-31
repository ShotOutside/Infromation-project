package com.rj.bd.infromation.service;

import java.util.List;

import com.rj.bd.infromation.entity.User;


public interface IUserService {

	public List<User> queryAll();
	public void UpdateUser(User user);
	public void InsertUser(User user);
	public void DeleteUser(String id);
}

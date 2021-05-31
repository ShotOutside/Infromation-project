package com.rj.bd.infromation.controller;

import java.util.List;

import com.rj.bd.infromation.entity.User;
import com.rj.bd.infromation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	public IUserService userService;

	@RequestMapping("/userQuery")
	public List<User> query() {

		return userService.queryAll();
	}

	@RequestMapping("/userAdd")
	public String add() {
		System.out.println();
		User user = new User();
		
		user.setName("李莫愁");

		userService.InsertUser(user);
        return "";
	}

	
	@RequestMapping("/userUpdate")
	public String update() {

		User user = new User();
		user.setId(3);
		user.setName("赤练仙子");

		userService.UpdateUser(user);
        return "";
	}
	
	
	
	@RequestMapping("/userDelete")
	public String delete() {

		 int id=3;

		userService.DeleteUser(id+"");
        return "";
	}
	
	
	
	
	
}

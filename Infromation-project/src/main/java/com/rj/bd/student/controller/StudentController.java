package com.rj.bd.student.controller;

import java.util.List;

import com.rj.bd.student.entity.Student;
import com.rj.bd.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

	@Autowired
	public IStudentService userService;

	@RequestMapping("/userQuery")
	public List<Student> query() {

		return userService.queryAll();
	}

	@RequestMapping("/userAdd")
	public String add() {
		System.out.println();
		Student user = new Student();
		
		user.setName("李莫愁");

		userService.InsertUser(user);
        return "";
	}

	
	@RequestMapping("/userUpdate")
	public String update() {

		Student user = new Student();
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

package com.rj.bd.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rj.bd.student.entity.Student;
import com.rj.bd.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * student模块的c层
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	public IStudentService userService;

	@RequestMapping("/queryAll")
	public List<Student> query() {

		return userService.queryAll();
	}

	@RequestMapping("/userAdd")
	public Map<String, Object> add() {
		Map<String, Object> map = new HashMap<String,Object>();
		System.out.println("------>addPerson");
		Student user = new Student();
		

		userService.InsertUser(user);
        return map;
	}

	
	@RequestMapping("/userUpdate")
	public String update() {

		Student user = new Student();

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

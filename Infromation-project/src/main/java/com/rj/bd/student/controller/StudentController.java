package com.rj.bd.student.controller;

import java.util.*;

import com.rj.bd.student.entity.Student;
import com.rj.bd.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * student模块的c层
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	public IStudentService userService;

	/**
	 * @desc   多表联查
	 * @return
	 */
	@RequestMapping("/queryAll")
	public List<Map<String, Object>> query() {
		System.out.println("query");

		List<Map<String, Object>> list = userService.queryAll();

		return list;

	}

	/**
	 * @desc   添加学生信息
	 * @return
	 */
	@RequestMapping("/add")
	public Map<String, Object> add(String uid, String uname, String sex, Date birth,String unumber,String password,String cname,
	String school,String departname) {
		System.out.println("Add");
		uid= UUID.randomUUID().toString();
		String cid=userService.queryByNametoId(cname);
		System.out.println(cid);
		birth=new Date();
		System.out.println(birth);
		String departid=userService.queryByNametodId(departname);
		userService.save(uid,uname,sex,birth,unumber,password,cid,school,departid);

        return null;
	}

	/**
	 * @desc   修改
	 * @return
	 */
	@RequestMapping("/update")
	public String update(String uid,String uname,String unumber,String sex,Date birth,String password) {

		userService.update(uid,uname,unumber,sex,birth,password);
        return "";
	}


	/**
	 * @desc  根据id删除
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String uid) {
		System.out.println("delete");

		userService.DeleteUser(uid);
        return "ok";
	}
	
	
	
	
	
}

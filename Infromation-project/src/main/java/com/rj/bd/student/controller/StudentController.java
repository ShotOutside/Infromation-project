package com.rj.bd.student.controller;

import java.util.*;

import com.rj.bd.student.entity.Student;
import com.rj.bd.student.service.IStudentService;
import com.rj.bd.teacher.entity.Teacher;
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
	public Map<String, Object> add(String uid, String uname, String sex, String birth,String unumber,String password,String cname,
	String school,String departname) {
		Map<String, Object> map = new HashMap<String,Object>();
		System.out.println("Add");
		uid= UUID.randomUUID().toString();
		String cid=userService.queryByNametoId(cname);
		System.out.println(cid);
		String departid=userService.queryByNametodId(departname);
		userService.save(uid,uname,sex,birth,unumber,password,cid,school,departid);

		map.put("msc", 200);
		map.put("text", "添加成功");
        return map;
	}

	/**
	 * @desc   修改
	 * @return
	 */
	@RequestMapping("/update")
	public Map<String, Object> update(String uid,String uname,String unumber,String sex,String birth,String password) {
		Map<String, Object> map = new HashMap<String,Object>();
		System.out.println("update");
		userService.update(uid,uname,unumber,sex,birth,password);
		map.put("msc", 200);
		map.put("text", "修改成功");
        return map;
	}


	/**
	 * @desc  根据id删除
	 * @return
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(String uid) {
		Map<String, Object> map = new HashMap<String,Object>();

		System.out.println("delete");
		userService.DeleteUser(uid);
		map.put("msc", 200);
		map.put("text", "删除成功");
        return map;
	}

	/**
	 * @desc  模糊查询
	 */
	@RequestMapping("/querybyname")
	public List<Map<String, Object>> queryByName(String uname){
		System.out.println("queryByName");
		List<Map<String, Object>> list = userService.queryByName(uname);

		return list;

	}


	/**
	 * 根据id查询单条
	 */

	@RequestMapping("/queryOne")
	public List<Map<String, Object>> queryByOne(String uid){
		System.out.println("student-->queryByOne");
		List<Map<String, Object>> list = userService.queryOne(uid);
		return list;

	}


}

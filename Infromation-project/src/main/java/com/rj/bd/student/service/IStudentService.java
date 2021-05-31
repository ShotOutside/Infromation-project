package com.rj.bd.student.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.rj.bd.student.entity.Student;


public interface IStudentService {

	public List<Student> queryAll();
	public void UpdateUser(Student user);
	public void DeleteUser(String uid);

	String queryByNametoId(String cname);

	String queryByNametodId(String departname);

	void save(String uid, String uname, String sex, Date birth, String unumber, String password, String cid, String school, String departid);
}

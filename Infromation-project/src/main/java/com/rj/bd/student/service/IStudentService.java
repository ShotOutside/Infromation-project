package com.rj.bd.student.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.rj.bd.student.entity.Student;


public interface IStudentService {

	List<Map<String, Object>> queryAll();
	public void DeleteUser(String uid);

	String queryByNametoId(String cname);

	String queryByNametodId(String departname);

	void save(String uid, String uname, String sex, Date birth, String unumber, String password, String cid, String school, String departid);

    void update(String uid, String uname, String unumber, String sex, Date birth, String password);

	List<Map<String, Object>> queryByName(String uname);
}

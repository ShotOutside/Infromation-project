package com.rj.bd.student.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.rj.bd.student.dao.StudentDao;
import com.rj.bd.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentServiceImpl implements IStudentService {

@Autowired
public StudentDao userDao;
	
	
	public List<Student> queryAll() {
		return userDao.queryAll();
	}

	@Transactional
	public void UpdateUser(Student user) {
		userDao.UpdateUser(user);
	}



	@Transactional
	public void DeleteUser(String uid) {
		userDao.DeleteUser(uid);
	}

	@Override
	public String queryByNametoId( String cname) {
		return userDao.queryByNametoId(cname);
	}

	@Override
	public String queryByNametodId(String departname) {
		return userDao.queryByNametodId(departname);
	}

	@Override
	public void save(String uid, String uname, String sex, Date birth, String unumber, String password, String cid, String school, String departid) {
		 userDao.save(uid,uname,sex,birth,unumber,password,cid,school,departid);
	}

}
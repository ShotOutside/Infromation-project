package com.rj.bd.student.service;

import java.util.List;

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
	public void InsertUser(Student user) {
		userDao.InsertUser(user);
	}

	@Transactional
	public void DeleteUser(String id) {
		userDao.DeleteUser(id);
	}

}

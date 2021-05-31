package com.rj.bd.student.service;

import java.util.List;

import com.rj.bd.student.entity.Student;


public interface IStudentService {

	public List<Student> queryAll();
	public void UpdateUser(Student user);
	public void InsertUser(Student user);
	public void DeleteUser(String id);
}

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
	
	
	public List<Map<String, Object>> queryAll(int page,int size) {
		return userDao.queryAll((page-1)*size, size);
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
	public void save(String uid, String uname, String sex, String birth, String unumber, String password, String cid, String school, String departid) {
		 userDao.save(uid,uname,sex,birth,unumber,password,cid,school,departid);
	}

	@Override
	public void update(String uid, String uname, String unumber, String sex, String birth, String password,String cname, String school,String departname) {
			userDao.update(uid,uname,unumber,birth,sex,password,cname,school,departname);
	}

	@Override
	public List<Map<String, Object>> queryByName(String uname,String unumber) {
		return userDao.queryByName(uname,unumber);
	}

	@Override
	public List<Map<String, Object>> queryOne(String uid) {
		return userDao.queryById(uid);
	}

	@Override
	public Object getLosCount() {
		return userDao.selectCount(null);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		return userDao.findAll();
	}


}

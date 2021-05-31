package com.rj.bd.student.dao;

import java.util.List;

import com.rj.bd.student.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface StudentDao {

	@Select("  select * from user  ")
	public List<Student> queryAll();
	
	@Update("update user set name=#{name} where id=#{id}")
	public void UpdateUser(Student user);

	@Insert("insert into user(id,name) values(#{id},#{name});")
	public void InsertUser(Student user);

	@Delete("delete from user where id=#{id}")
	public void DeleteUser(String id);
	
	
	
	
}

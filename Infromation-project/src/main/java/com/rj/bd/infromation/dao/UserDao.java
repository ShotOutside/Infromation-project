package com.rj.bd.infromation.dao;

import java.util.List;

import com.rj.bd.infromation.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserDao {

	@Select("  select * from user  ")
	public List<User> queryAll();
	
	@Update("update user set name=#{name} where id=#{id}")
	public void UpdateUser(User user);

	@Insert("insert into user(id,name) values(#{id},#{name});")
	public void InsertUser(User user);

	@Delete("delete from user where id=#{id}")
	public void DeleteUser(String id);
	
	
	
	
}

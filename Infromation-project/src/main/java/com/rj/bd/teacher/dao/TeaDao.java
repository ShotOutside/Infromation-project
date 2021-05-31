package com.rj.bd.teacher.dao;
/**
 * @desc   teacher表的持久层
 */


import com.rj.bd.teacher.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeaDao {
    @Select("  select * from teacher  ")
    List<Teacher> queryTea();

    @Delete("delete from teacher where tid = #{tid}")
    void deleteOne(String tid);

    @Select("select tname from teacher")
    public List<Teacher> queryName();

    @Update("update teacher set tname = #{tname},sex = #{sex},birth = #{birth},tnumber = #{tnumber},password = #{password},school = #{school},token = #{token} where tid=#{tid}")
    void updateTea(String tid);

    @Select("  select * from teacher where tid = #{tid}")
    Teacher queryByID(String tid);

    @Insert("insert into teacher(tid,tname,sex,birth,tnumber,password,school,token) values(#{tid},#{tname},#{sex},#{birth},#{tnumber},#{password},#{school},#{token});")
    void addTea();

    @Select("SELECT * FROM teacher where tname like CONCAT('%',#{tname},'%')")
    List<Teacher> SelectName(String tname);
}

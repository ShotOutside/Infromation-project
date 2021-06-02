package com.rj.bd.teacher.dao;
/**
 * @desc   teacher表的持久层
 */


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rj.bd.teacher.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeaDao extends BaseMapper<Teacher> {
    @Select("  select * from teacher  ")
    List<Teacher> queryTea();

    @Delete("delete from teacher where tid = #{tid}")
    void deleteOne(String tid);

    @Select("select tname from teacher")
    public List<Teacher> queryName();


    @Select("  select * from teacher where tid = #{tid}")
    Teacher queryByID(String tid);


    @Select("SELECT * FROM teacher where tname like CONCAT('%',#{tname},'%')")
    List<Teacher> SelectName(String tname);

    @Select("select * from teacher")
    List<Map<String, Object>> findAll();
}

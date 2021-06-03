package com.rj.bd.classes.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rj.bd.classes.entity.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author ShiJie
 * @desc
 * @time 2021-05-31-16:49
 */

@Mapper
public interface ClassesDao extends BaseMapper<Classes> {

    @Select("select * from classes where cid=#{cid}")
    public Map<String, Object> queryid(String cid);
}

package com.rj.bd.root.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rj.bd.root.entity.Root;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RootDao extends BaseMapper<Root> {
}

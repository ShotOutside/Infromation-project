package com.rj.bd.root.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rj.bd.root.entity.Root;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RootDao {
    Root selectOne(LambdaQueryWrapper<Root> lambdaQueryWrapper);
}

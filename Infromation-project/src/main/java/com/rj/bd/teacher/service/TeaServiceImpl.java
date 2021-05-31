package com.rj.bd.teacher.service;
/**
 * @desc   teacher表m层接口实现类
 */


import com.rj.bd.teacher.dao.TeaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaServiceImpl implements ITeaService{

    @Autowired
    public TeaDao teaDao;

}

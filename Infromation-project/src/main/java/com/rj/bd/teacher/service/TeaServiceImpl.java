package com.rj.bd.teacher.service;
/**
 * @desc   teacher表m层接口实现类
 */


import com.rj.bd.teacher.dao.TeaDao;
import com.rj.bd.teacher.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeaServiceImpl implements ITeaService{

    @Autowired
    public TeaDao teaDao;


    @Override
    public List<Teacher> query() {
        return teaDao.queryTea();
    }

    @Override
    public void delete(String tid) {
        teaDao.deleteOne(tid);
    }

    @Override
    public List<Teacher> queryTname() {
        return teaDao.queryName();
    }



    @Override
    public Teacher queryOne(String tid) {
        return teaDao.queryByID(tid);
    }



    @Override
    public List<Teacher> queryName(String tname) {
        return teaDao.SelectName(tname);
    }

    @Override
    public void updateById(Teacher teacher) {
        teaDao.updateById(teacher);
    }

    @Override
    public void save(Teacher teacher) {
        teaDao.insert(teacher);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return teaDao.findAll();
    }
}

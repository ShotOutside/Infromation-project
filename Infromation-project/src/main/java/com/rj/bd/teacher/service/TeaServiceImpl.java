package com.rj.bd.teacher.service;
/**
 * @desc   teacher表m层接口实现类
 */


import com.rj.bd.teacher.dao.TeaDao;
import com.rj.bd.teacher.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void updateOne(String tid) {
        teaDao.updateTea(tid);
    }

    @Override
    public Teacher queryOne(String tid) {
        return teaDao.queryByID(tid);
    }

    @Override
    public void addOne() {
        teaDao.addTea();
    }

    @Override
    public List<Teacher> queryName(String tname) {
        return teaDao.SelectName(tname);
    }
}

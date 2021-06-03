package com.rj.bd.classes.service;

import com.rj.bd.classes.dao.ClassesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ShiJie
 * @desc
 * @time 2021-05-31-16:50
 */

@Service
public class ClassesImpl implements IClassesService{

    @Autowired
    public ClassesDao classesDao;

    @Override
    public Map<String, Object> queryid(String cid) {
        return classesDao.queryid(cid);
    }
}

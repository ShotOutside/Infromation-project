package com.rj.bd.teacher.service;

import com.rj.bd.teacher.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @desc   teacher表m层的接口
 */

public interface ITeaService {

    List<Teacher> query();

    void delete(String tid);

    List<Teacher> queryTname();



    Teacher queryOne(String tid);


    List<Teacher> queryName(String name);

    void updateById(Teacher teacher);

    void save(Teacher teacher);

    List<Map<String, Object>> findAll();
}

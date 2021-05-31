package com.rj.bd.teacher.service;

import com.rj.bd.teacher.entity.Teacher;

import java.util.List;

/**
 * @desc   teacher表m层的接口
 */

public interface ITeaService {

    List<Teacher> query();

    void delete(String tid);

    List<Teacher> queryTname();

    void updateOne(String tid);

    Teacher queryOne(String tid);

    void addOne();

    List<Teacher> queryName(String name);
}

package com.rj.bd.teacher.controller;
/**
 * @desc   teacher表的c层
 */


import com.rj.bd.teacher.entity.Teacher;
import com.rj.bd.teacher.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeaController {

    @Autowired
    public ITeaService teaService;


    /**
     * 查询全部
     * @return
     */
    @CrossOrigin
    @RequestMapping("/query")
    public List<Teacher> queryAll(){
        System.out.println("teacher-->queryAll");
        List<Teacher> list = teaService.query();
        return list;
    }

    /**
     * 查询所有老师名字
     * @return
     */
    @CrossOrigin
    @RequestMapping("/delete")
    public Map<String, Object> delete(String tid){
        Map<String, Object> map = new HashMap<String,Object>();
        System.out.println("teacher-->delete");
        teaService.delete(tid);
        map.put("msc", 200);
        map.put("text", "删除成功");
        return map;
    }

    /**
     *  根据id查询单条
     */
    @CrossOrigin
    @RequestMapping("/queryOne")
    public Teacher queryByOne(String tid){
        System.out.println("teacher-->queryByOne");
        Teacher teacher = teaService.queryOne(tid);
         return teacher;

    }

    /**
     *修改
     */
    @CrossOrigin
    @RequestMapping("/updateOne")
    public Map<String, Object> update(String tid){
        Map<String, Object> map = new HashMap<String,Object>();
        System.out.println("teacher-->update");
        teaService.updateOne(tid);
        map.put("msc", 200);
        map.put("text", "修改成功");
        return map;
    }

    /**
     * 添加
     * @return
     */
    @CrossOrigin
    @RequestMapping("/addOne")
    public Map<String, Object> add(){
        Map<String, Object> map = new HashMap<String,Object>();
        System.out.println("teacher-->addOne");
        teaService.addOne();
        map.put("msc", 200);
        map.put("text", "添加成功");
        return map;

    }

    /**
     *条件查询
     */
    @CrossOrigin
    @RequestMapping("/queryname")
    public List<Teacher> queryName(String tname){
        System.out.println("teacher-->queryName");
        List<Teacher> list = teaService.queryName(tname);
        return list;
    }


}

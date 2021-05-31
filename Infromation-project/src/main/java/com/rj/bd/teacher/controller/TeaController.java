package com.rj.bd.teacher.controller;
/**
 * @desc   teacher表的c层
 */


import com.rj.bd.teacher.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeaController {

    @Autowired
    public ITeaService teaService;
}

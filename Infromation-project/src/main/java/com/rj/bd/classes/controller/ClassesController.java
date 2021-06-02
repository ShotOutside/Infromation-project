package com.rj.bd.classes.controller;

import com.rj.bd.classes.service.IClassesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/classes")
@Api(value = "教室类")
public class ClassesController {

    @Autowired
    public IClassesService classesService;

    @RequestMapping(method = RequestMethod.POST,value = "/queryId")
    @ApiOperation(value = "获取教室信息", notes = "通过id获取信息")
    public Map<String, Object> queryid(@ApiParam(value = "教室id",required = true) String cid){

        return classesService.queryid(cid);
    }

}

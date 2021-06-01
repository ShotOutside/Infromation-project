package com.rj.bd.root.controller;

import com.rj.bd.root.service.IRootService;
import com.rj.bd.root.utils.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("root")
@RestController

public class RootController {
    @Autowired
    public IRootService rootService;
    @Autowired
    public Email email;



    @RequestMapping("/fa")
    public void fa(String code){
        email.email("1758855483@qq.com",code);

    }
}

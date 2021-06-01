package com.rj.bd.root.controller;

import com.rj.bd.root.service.IRootService;
import com.rj.bd.root.utils.Email;
import com.rj.bd.root.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.UUID;

@RequestMapping("root")
@RestController

public class RootController {
    @Autowired
    public IRootService rootService;
    @Autowired
    public Email email;


    /**
     * @desc  发送邮件测试
     * @param code
     * @param yAccount
     */
    @RequestMapping("/fa")
    public void fa(String code,String yAccount){
        code= UUID.randomUUID().toString().substring(0,5);
        email.email("1758855483@qq.com",code);

    }

    @RequestMapping("login")
    public Map<String, Object> login(String code,String rname){
        Jedis jedis = RedisUtil.getRedisConnection();

        code= UUID.randomUUID().toString().substring(0,5);
        email.email("1758855483@qq.com",code);
        jedis.set(rname,code);
        jedis.expire(rname,120);
        return rootService.login(code,rname);


    }
}

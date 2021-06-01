package com.rj.bd.root.service;

import com.rj.bd.root.dao.RootDao;
import com.rj.bd.root.utils.DataUtil;
import com.rj.bd.root.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@Service
public class RootServiceImpl implements IRootService{
    @Autowired
    public RootDao rootDao;

    @Override
    public Map<String, Object> login(String code, String rname) {
        if (code==null || code.equals(""))
            return DataUtil.printf(-1,"请输入验证码");

        Jedis redisConnection = RedisUtil.getRedisConnection();
        String recode = redisConnection.get(rname);
        if (recode==null) return DataUtil.printf(-5,"验证码失效请重新获取");
        Map<String, Object> data = new HashMap<String,Object>();
        if (code==recode) {
            return DataUtil.printf(0, "登录成功", data);
        }
        return  null;

    }

}

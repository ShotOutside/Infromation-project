package com.rj.bd.root.controller;

import com.rj.bd.root.entity.Root;
import com.rj.bd.root.service.IRootService;
import com.rj.bd.root.utils.Email;
import com.rj.bd.root.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("root")
@RestController

public class RootController {
    @Autowired
    public IRootService rootService;
    @Autowired
    public Email email;


    public String code;

    /**
     * @desc  发送邮件测试
     * @param code
     * @param yAccount
     */
    @RequestMapping("/fa")
    @CrossOrigin
    public void fa(String code,String yAccount){
        code= UUID.randomUUID().toString().substring(0,5);
        email.email("1844484694@qq.com",code);

    }

        /**
         * 发送验证码到redis和邮箱
         * @param rname
         * @param youxiang
         * @return
         */
    @RequestMapping("/sendCode")
    @CrossOrigin
    public Map<String, Object> setCode(String rname,String youxiang){
        Map<String , Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getRedisConnection();

            youxiang = rootService.selectEmail(rname);              //根据账号获取邮箱
        if (youxiang!=null){
            System.out.println("账号：--"+rname+"--验证码发送到了："+youxiang);
        }else {
            String text="账号:--"+rname+"--错误或该账号没有绑定邮箱";
            System.out.println(text);
        }


        code= UUID.randomUUID().toString().substring(0,5);
        email.email(youxiang,code);
        jedis.set(rname,code);
        jedis.expire(rname,120);
        map.put("msc", 200);
        map.put("text", "---发送验证码成功---");
        return map;


    }


        /**
         * 验证码登录
         * @param rname
         * @param password
         * @param message
         * @return
         */
        @RequestMapping("/login")
        @CrossOrigin
        public Map<String, Object> loginCode(String rname,String password,String message)
        {
            Root root = rootService.loginByRname(rname);
            Map<String , Object> map = new HashMap<String, Object>();
            Jedis jedis=new Jedis("127.0.0.1", 6379);//虚拟机端口号
            String tokenMessage = jedis.get(rname);         //从redis中获取key值 相当于get 键名
            System.out.println("从html网页获取到的验证码为："+message);
            System.out.println("从redis获取到的验证码为："+tokenMessage);               //打印得到的验证码
            //判读是否为空
            if ( root==null ) 								//判断账号是否正确
            {
                map.put("msc", -1);
                map.put("text", "没有此账号");
            }
            else //不为再进行数据比对
            {
                boolean loginState = root.getPassword().equals(password);//判断账号和密码是否正确
                if (loginState)
                {
                    if (tokenMessage!=null) {					//判断验证码是否存在

                        if (message.equals(tokenMessage))		//判断验证码是否正确
                        {
                            map.put("msc", 200);
                            map.put("text", "验证码正确,登录成功");
                        }else if (tokenMessage!=code) {			//判断验证码是否正确
                            map.put("msc", -1);
                            map.put("text", "验证码错误,请重试");
                        }

                    } else{										//判断验证码是否过期
                        map.put("msc", -1);
                        map.put("text", "超过120秒,验证码失效了,登陆失败");
                    }
                }
                else 											//判断密码是否正确
                {
                    map.put("msc", -1);
                    map.put("text", "密码错误");
                }
            }


            return map;
        }
}

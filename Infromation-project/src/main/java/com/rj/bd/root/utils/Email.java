package com.rj.bd.root.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class Email {


    @Bean
    public JavaMailSenderImpl JavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("1758855483@qq.com");
        mailSender.setPassword("ysccvlzzjtwzbjgg");
        return  mailSender;
    }




    public void email(String addressee,String code){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("1758855483@qq.com");
        simpleMailMessage.setTo(addressee);
        simpleMailMessage.setSubject("验证码");
        simpleMailMessage.setText("验证码为:"+code);

    }

}

package com.rj.bd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * qidong SpringBoot
 *
 */
@SpringBootApplication
@MapperScan("com.rj.bd.*.dao")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

    }

    @Bean
    public JavaMailSenderImpl JavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("1758855483@qq.com");
        mailSender.setPassword("ysccvlzzjtwzbjgg");
        return  mailSender;
    }

}

package com.rj.bd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}

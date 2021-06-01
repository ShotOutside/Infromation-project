package com.rj.bd.teacher.entity;
/**
 * @desc   teacher表的实体类
 */


import lombok.Data;

import java.util.Date;

@Data
public class Teacher {

    public String tid;
    public String tname;
    public String sex;
    public String tnumber;
    public String password;
    public String school;
    public String token;
    public String birth;
}

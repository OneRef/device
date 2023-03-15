package com.example.demo.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
/*
接受前端登录请求的参数
 */
@Data
public class UserDTO {   //来自接口参数
    private int id;
    private String username;

    private String password;
    private String realname;
    private int idep;
    private int age;
    private String gender;
    //以上为注册时所用信息
    private String avatar;
    private int salary;
    private  String entryyear;//入职年份
    private String ismanager ;

    private String token;

}

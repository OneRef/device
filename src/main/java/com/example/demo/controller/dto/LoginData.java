package com.example.demo.controller.dto;

import lombok.Data;
//此类用于存储接口返回参数的实体类
//登录返回信息
@Data
public class LoginData {
    private int id;
    private String username;
    private String realname;
    private int idep;
    private int age;
    private String gender;
    private String avatar;
    private int salary;
    private  String entryyear;//入职年份
    private String token;
    private String ismanager ;
}

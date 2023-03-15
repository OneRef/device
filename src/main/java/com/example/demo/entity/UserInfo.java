package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//对应数据库

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName(value = "tbl_employee")
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private int id        ;
    private String username   ;
    private String realname  ;
    private String password  ;
    private int    id_dep    ;
    private String gender    ;
    private int    age       ;
    private int    salary    ;
    private String entryyear ;

    private String isnew     ;
    private String avatar     ;
    private String ismanager     ;

    //Own构造器
    public UserInfo(int id,String username,String avatar,int age){
        this.id=id;
        this.age=age;
        this.username=username;
        this.avatar=avatar;
    }


}

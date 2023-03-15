package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//对应数据库
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tbl_admin")
public class Admin {
    @TableId(type = IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private int grant; //是否拥有创建管理员权限
}

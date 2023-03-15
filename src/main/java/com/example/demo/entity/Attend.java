package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

//对应数据库
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tbl_attend")
public class Attend {
    @TableId(type = IdType.AUTO)
    private int id;
    private String realname;
    private String time;
    private int late;
    private String date;
    private String photo;
}


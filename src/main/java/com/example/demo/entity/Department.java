package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tbl_department")
public class Department {
    @TableId
    private String id      ;
    private String name    ;
    private String account ;
    private String local    ;
}

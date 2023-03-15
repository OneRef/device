package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tbl_department")
public class Department {
    @TableId(type = IdType.AUTO)
    private String id      ; //部门id
    private String name    ; //部门名字
    private String number  ; //部门人数
    private String local    ; //部门位置（门牌）
}

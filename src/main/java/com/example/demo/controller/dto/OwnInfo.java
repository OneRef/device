package com.example.demo.controller.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnInfo {
    @TableId(type = IdType.AUTO)
    private int id;
    private String username   ;
    private String avatar;
    private int age;
}

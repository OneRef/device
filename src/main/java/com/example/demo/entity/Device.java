package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tbl_devices")
public class Device {
    @TableId(type = IdType.AUTO)
    private int     id;
    private String  name                  ;    //设备名称
    private String  number                     ;           //设备编号
    private String  produceDate              ; //生产日期
    private String  manufacture          ;//生产商
    private String  principle          ;//负责人
    private String  phoneNumber             ;//负责人联系电话
    private int     interval             ;//需定期维护的时间 / 月
    private int     needMaintain             ;//待维护吗？
    private String  local                 ;//设备位置
}

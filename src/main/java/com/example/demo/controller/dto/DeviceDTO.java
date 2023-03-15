package com.example.demo.controller.dto;

import lombok.Data;

@Data
public class DeviceDTO {
    private String name;   //设备名称
    private String number; //设备编号
    private String produceDate; //生产日期
    private String manufacture;//生产商
    private String principle;//负责人
    private String phoneNumber;//负责人联系电话
    private int interval;//需定期维护的时间 / 月
    private int needMaintain;//待维护吗？
    private String local;//设备位置
}

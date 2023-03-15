package com.example.demo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.entity.Device;
import com.example.demo.mapper.AttendMapper;
import com.example.demo.mapper.DeviceMapper;
import com.example.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    AttendMapper attendMapper;

    public Result getAll(){
        return new Result(Constants.CODE_200,"查询成功", deviceMapper.findAll());
    }
    public  Result getOwn(int id){
        String name=attendMapper.selectById(id);//查询姓名
        System.out.println("名字是"+name);
        return new Result(Constants.CODE_200,"查询成功", deviceMapper.findOwn(name));
    }
    public Result insert(Device device){
        System.out.println("插入数据"+ device.getName());
        deviceMapper.saveA(device.getName(),device.getNumber(),device.getProduceDate(),device.getManufacture(),device.getPrinciple() ,device.getPhoneNumber(),device.getInterval(),device.getNeedMaintain(),device.getLocal());
        return  new Result(Constants.CODE_200,"录入成功",device);




    }
}

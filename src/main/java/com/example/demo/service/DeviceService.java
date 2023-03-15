package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.entity.Device;

import java.util.List;

public interface DeviceService  {

    public Result getAll();

    Result getOwn(int id);

    Result insert(Device device);

}

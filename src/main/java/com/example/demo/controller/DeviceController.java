package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.controller.dto.DeviceDTO;
import com.example.demo.controller.requestBody.OwnDeviceRequest;
import com.example.demo.entity.Device;
import com.example.demo.service.impl.DeviceServiceImpl;
import com.example.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceServiceImpl deviceService;

    @GetMapping("get")
    public Result get(){
        return  deviceService.getAll();
    }

    @GetMapping("OwnDevice")
    public Result getOwn(@RequestBody OwnDeviceRequest id){ return deviceService.getOwn(id.getId());}

    @PostMapping("insert")
    public Result saveNewDevice(@RequestBody Device device){

        return new Result(Constants.CODE_200,"保存成功", deviceService.insert(device));
    }
}

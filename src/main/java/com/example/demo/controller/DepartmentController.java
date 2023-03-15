package com.example.demo.controller;


import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.entity.Department;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/depart")
public class DepartmentController {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("get")
    private Result get(){

        departmentMapper.updateNumber();//通过查询employee表,更新部门人数信息
     return new Result(Constants.CODE_200,"获取成功", departmentMapper.getAll());
    }

    @PostMapping("save")
    public boolean save(@RequestBody Department department){
        //新增或者更新
        return departmentService.saveDepartment(department);
    }
}

package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.Result;
import com.example.demo.entity.Department;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.AttendMapper;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> {
    @Autowired
    private DepartmentMapper departmentMapper;

    public boolean saveDepartment(Department department) {
        return saveOrUpdate(department);
    }

    public Result getEmployee(int depId){
        return  Result.success("查询成功",departmentMapper.getEmployee(depId));
    }

}


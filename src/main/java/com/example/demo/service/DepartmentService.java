package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Department;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> {
    public boolean saveDepartment(Department department) {
        return saveOrUpdate(department);
    }


}


package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Department;
import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    @Select("Select * from tbl_department")
    public List<Department> getAll();//查询真实姓名

    @Update("update tbl_department set number = (select count(*) from tbl_employee where tbl_department.id=tbl_employee.id_dep)")
    void updateNumber();
}

package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.controller.dto.OwnInfo;
import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {
    @Select("Select * from tbl_employee")
    public List<UserInfo> getAll();

    @Update("update tbl_employee set username=#{username},age = #{age}, avatar = #{avatar} where id =#{id}" )
    int saveOwn(int id,String username,int age,String avatar);

    @Select("select * from tbl_employee where id =#{id} ")
    UserInfo getById(int id);
}

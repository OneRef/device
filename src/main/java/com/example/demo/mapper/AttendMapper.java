package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Attend;
import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public  interface AttendMapper extends BaseMapper<Attend>{


    @Select("Select realname from tbl_employee where id= #{id}")
    public String selectById(int id);//查询真实姓名

    @Insert("insert into tbl_attend(id,realname,time,late,date,photo) values (#{id},#{realname},#{time},#{late},#{date},#{photo})")
    int insert(Attend attend);

    @Select("Select * from tbl_attend where id = #{id}")
    List<Attend> selectOwnAttend(int id);//根据id查询该id所有的签到记录

    @Select("Select * from tbl_attend")
    List<Attend> findAll();
}

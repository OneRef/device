package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.common.Result;
import com.example.demo.controller.dto.CountLastDTO;
import com.example.demo.controller.dto.DepLastDTO;
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

    @Insert("insert into tbl_attend(id,realname,time,late,date,photo,date_year,date_month,date_day,id_dep,department) values (#{id},#{realname},#{time},#{late},#{date},#{photo},#{date_year},#{date_month},#{date_day},#{id_dep},#{department})")
    int insert(Attend attend);

    @Select("Select * from tbl_attend where id = #{id}")
    List<Attend> selectOwnAttend(int id);//根据id查询该id所有的签到记录

    @Select("Select * from tbl_attend")
    List<Attend> findAll();

    @Select("SELECT count(*) from tbl_attend where date = #{date} and id = #{id}")
    int isAttend(int id,String date);

    @Select("SELECT * from tbl_attend")
    List<Attend> getAll();


    @Select("select id_dep from tbl_employee where id = #{id}")
    int getId_dep(int id);

    @Select("select name from tbl_department where id = #{id}")
    String getDepName(int id);

    @Select("SELECT department,COUNT(*) AS late FROM tbl_attend WHERE late=1 GROUP BY department;")
    List<DepLastDTO> getDepLast();

    @Select("SELECT realname,COUNT(*) AS late FROM tbl_attend WHERE late=1 GROUP BY realname;")
    List<CountLastDTO> getCountLast();
}

package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@EnableCaching// 开启缓存
@SpringBootApplication
//@MapperScan("com/example/demo/mapper")
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}


/**<?xml version="1.0" encoding="UTF-8"?>
 <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 <mapper namespace="com.example.demo.mapper.UserMapper">
 <update id="update">
 UPDATE  `managedb`.`tbl_employee`
 <set>
 <if test="account != null">
 account=#{account},
 </if>
 <if test="name != null">
 name=#{name},
 </if>
 <if test="id_dep != null">
 id_dep=#{id_dep},
 </if>
 <if test="gender != null">
 gender=#{gender},
 </if>
 <if test="age != null">
 age=#{age},
 </if>
 <if test="salary != null">
 salary=#{salary},
 </if>
 <if test="ismanager != null">
 ismanager=#{ismanager},
 </if>
 <if test="isnew != null">
 isnew=#{isnew}
 </if>

 </set>
 <where>
 id = #{id}
 </where>
 </update>
 </mapper>
 */
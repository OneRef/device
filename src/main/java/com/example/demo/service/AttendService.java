package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.controller.dto.AttendDTO;
import com.example.demo.controller.dto.CountLastDTO;
import com.example.demo.controller.dto.DepLastDTO;
import com.example.demo.entity.Attend;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.AttendMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AttendService extends ServiceImpl<AttendMapper, Attend> {

    @Autowired
    private  AttendMapper attendMapper;


    public  Result attend(AttendDTO attend) {


        // 获取当前日期
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatterDate  = DateTimeFormatter.ofPattern("yyyy-MM-dd");//转换恰当格式 年月日
        System.out.println(date.format(formatterDate));
        // 获取当前时间
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");//转换成十分秒
        System.out.println(time.format(formatterTime));
        boolean booleanLate=isLate(time);
        int late;
        if (booleanLate)  late=1;
        else late=0;//布尔型和整形转换

        attend.setLate(late);
        attend.setDate(date.toString());
        attend.setTime(time.toString());
        int id_dep=getId_dep(attend.getId());
        String department=getDepartment(id_dep);
        if (attendMapper.isAttend(attend.getId(),date.toString())>0){
            //表示今日已签到
            return new Result(Constants.CODE_600,"签到失败，今日已签到",null);
        }
        attend.setRealname(attendMapper.selectById(attend.getId()));
        System.out.println("数据库放入"+attend.getId()+attend.getRealname()+formatterTime.toString()+attend.getLate()+formatterDate.toString()+attend.getPhoto());

        Attend a = new Attend(attend.getId(),attend.getRealname(),time.toString(),attend.getLate(),date.toString(),attend.getPhoto(),date.getYear(),date.getMonthValue(),date.getDayOfMonth(),id_dep,department);
        attendMapper.insert(a);
        return new Result(Constants.CODE_200,"签到成功",attend);



    }

    private String getDepartment(int id_dep) {
        return attendMapper.getDepName(id_dep);
    }

    public Result getOwnAttend(int id) {


        return new Result(Constants.CODE_200,"查询成功",attendMapper.selectOwnAttend(id));
    }



        //判断是否迟到
    public static  boolean isLate(LocalTime time){
        LocalTime ddl=LocalTime.of(9,0,0); //上班时间九点整
        return time.compareTo(ddl) >= 0;//前两句的简化写法
    }

    public List<Attend> getAllAtend() {
        return attendMapper.getAll();

    }

    public int getId_dep(int id){
        return attendMapper.getId_dep(id);
    }

    public List<DepLastDTO> getDepLast() {
        return attendMapper.getDepLast();
    }

    public List<CountLastDTO> getCountLast() {
        return  attendMapper.getCountLast();
    }


//    public String insertDb(int id,String realname,DateTimeFormatter time,int late,DateTimeFormatter date,String photo){
//        Attend attend=new Attend(id,realname,time,late,date,photo);
//        attendMapper.insert(attend);
//        return  null;
//    }

}

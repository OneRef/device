package com.example.demo.service;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.controller.UserController;
import com.example.demo.controller.dto.*;
import com.example.demo.entity.Attend;
import com.example.demo.entity.UserInfo;
import com.example.demo.exception.ServiceException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.TokenUtils;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,UserInfo> {
    public String msg=null;
    public Result saveUser(UserInfo userInfo) {
         saveOrUpdate(userInfo);
        OwnInfo ownInfo=new OwnInfo(userInfo.getId(),userInfo.getUsername(),userInfo.getAvatar(),userInfo.getAge());
         Result result=new Result(Constants.CODE_200,"修改成功",ownInfo);
         return result;
    }

    public LoginData login(UserDTO userDTO) {
        UserInfo one = getUserInfo(userDTO);

        if(one !=null){
            BeanUtil.copyProperties(one,userDTO,true);
            //设置Token
            String token = TokenUtils.genToken(one.getId()+"",one.getPassword());
            userDTO.setToken(token);
            LoginData loginData=new LoginData();

            loginData.setId(userDTO.getId());
            loginData.setRealname(userDTO.getRealname()) ;
            loginData.setAvatar(userDTO.getAvatar());
            loginData.setIdep(userDTO.getIdep());
            loginData.setGender(userDTO.getGender());
            loginData.setAge(userDTO.getAge());
            loginData.setSalary(userDTO.getSalary());
            loginData.setEntryyear(userDTO.getEntryyear());
            loginData.setIsmanager(userDTO.getIsmanager());
            loginData.setUsername(userDTO.getUsername());
            loginData.setToken(userDTO.getToken());

            //隐藏掉密码

            return loginData;
        }else throw new ServiceException(Constants.CODE_600,"用户名或密码错误");

    }
    //注册方法
    public RegisterData register(UserDTO userDTO) {
        RegisterData returninfo=new RegisterData();

        UserInfo one = getUserInfo(userDTO);
        if (one==null){
            one=new UserInfo();
            BeanUtil.copyProperties(userDTO,one,true);
            saveUser(one);//存入数据库
             returninfo.setId(one.getId());
             returninfo.setUsername(one.getUsername());


        }else throw new ServiceException(Constants.CODE_600,"用户已存在");
        return returninfo;
    }
    private UserInfo getUserInfo(UserDTO userDTO){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        UserInfo one;
        try{
            one=getOne(queryWrapper);

        } catch (Exception e){
            throw  new ServiceException(Constants.CODE_500,"系统错误");

        }
        return one;
    }

    public Result managerSaveUser(UserInfo userInfo) {
        saveOrUpdate(userInfo);
        Result result=new Result(Constants.CODE_200,"修改成功",userInfo);
        return result;
    }
    public String ggg(int id){
        System.out.println("测试1"+id);
        try {

//
//            UserInfo userInfo = new UserInfo();
//            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
//            queryWrapper.eq("id", id);
//            userInfo = getOne(queryWrapper);
//            return userInfo.getRealname();
              return  "fufu";
        }catch(Exception e){throw new ServiceException(Constants.CODE_600,"查询用户名失败");}
    }

}

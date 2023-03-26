package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.controller.dto.AttendDTO;
import com.example.demo.controller.dto.OwnInfo;
import com.example.demo.controller.dto.UserDTO;
import com.example.demo.entity.Attend;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.AttendMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.AttendService;
import com.example.demo.service.UserService;
import com.example.demo.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.example.demo.common.Constants.CODE_200;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@CrossOrigin
@Api
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private AttendService attendService;

    @PostMapping("register")//注册--接口
    public Result register(@RequestBody UserDTO userDTO){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        String realname = userDTO.getRealname();//真实姓名
        int idep = userDTO.getIdep();//部门编号
        int age = userDTO.getAge();//部门编号
        String gender = userDTO.getGender();//性别

        if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return  Result.error(Constants.CODE_400,"参数错误");
        }
        Result result=new Result(CODE_200,"注册成功",userService.register(userDTO));
        return result;

    }


    @PostMapping("login")
    public Result login(@RequestBody UserDTO userDTO){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return  Result.error(Constants.CODE_400,"参数错误");
        }
        return Result.success("登录成功",userService.login(userDTO));

    }
    @GetMapping("getUserInfo")
    public Result get(@RequestParam("id") Integer id){
        return new Result(Constants.CODE_200,"查询成功",userMapper.getById(id));

    }

    @RequestMapping(value = "save",method = PUT)
    public Result save(@RequestBody OwnInfo ownInfo){
//        //过滤
//        UserInfo userInfo = new UserInfo(ownInfo.getId(),ownInfo.getUsername(),ownInfo.getAvatar(),ownInfo.getAge());
//        //新增或者更新
//        return userService.saveUser(userInfo);
        userService.saveOwnUser(ownInfo);
        return Result.success("修改成功",ownInfo);
    }
    @RequestMapping(value = "manager/save",method = PUT)
    public Result save(@RequestBody UserInfo userInfo){
        //过滤
        //新增或者更新
        return userService.managerSaveUser(userInfo);
    }

    @GetMapping("manager/get")
    public Result getUserInfo(){
        return new Result(Constants.CODE_200,"查询成功",userMapper.getAll());
    }



    @DeleteMapping("delete")
    public Integer delete(@RequestParam Integer id){
        return userMapper.deleteById(id);
    }

   // @CachePut(value = "attend",key="'frontAll'")
    @PostMapping("attendance")
    public Result attend(@RequestBody AttendDTO attendDTO){

        return attendService.attend(attendDTO);
    }


    //@CacheEvist删除的时候用，清除缓存
    @GetMapping("getAttendance")
   // @Cacheable(value="attend", key="'frontAll'")
    public Result attends(@RequestParam int id){
       // return attendService.getOwnAttend(attendDTO.getId());
        return attendService.getOwnAttend(id);
    }

    @GetMapping("getAllAttend")
    public Result attends(){
       return Result.success("查询成功",attendService.getAllAtend());
    }


    @GetMapping("getDepLast")
    public Result getLastInfo(){
        return Result.success("查询成功",attendService.getDepLast());
    }

    @GetMapping("countLast")
    public Result getCountLast(){
        return Result.success("查询成功",attendService.getCountLast());
    }

}

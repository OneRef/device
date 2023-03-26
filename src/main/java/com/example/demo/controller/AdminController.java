package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.controller.dto.UserDTO;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.ConstantCallSite;
import java.util.List;

import static com.example.demo.common.Constants.CODE_200;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@CrossOrigin
@Api
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("getAll")
    public Result getUserInfo(){
     return new Result(Constants.CODE_200,"查询成功",adminMapper.getAll());
    }

    @RequestMapping(value = "save",method = PUT)
    public Result save(@RequestBody UserInfo userInfo){
        return userService.managerSaveUser(userInfo);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestParam Integer id){
        userMapper.deleteById(id);
        return new Result(Constants.CODE_200,"删除成功or该用户不存在",id);

    }
    @PostMapping("insert")//注册--接口
    public Result register(@RequestBody UserDTO userDTO){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();


        if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return  Result.error(Constants.CODE_400,"参数错误");
        }
        return new Result(CODE_200,"注册成功",userService.register(userDTO));

    }

}

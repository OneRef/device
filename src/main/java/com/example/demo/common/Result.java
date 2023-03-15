package com.example.demo.common;

import com.example.demo.controller.dto.LoginData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
*接口统一的包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result
{
    private String code;
    private String msg;
    private Object data;

    public static Result success(){//返回成功信息
        return  new Result(Constants.CODE_200,"",null);
    }
    public static Result success(Object data){//返回成功信息
        return  new Result(Constants.CODE_200,"",data);
    }
    public static Result error(String code, String msg){//返回成功信息
        return  new Result(code,msg,null);
    }
    public static Result error(){//返回成功信息
        return  new Result(Constants.CODE_500,"系统错误",null);
    }

    public static Result success( String msg, Object data) {
        return new Result(Constants.CODE_200,msg,data);
    }

}

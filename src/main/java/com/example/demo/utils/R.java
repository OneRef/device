package com.example.demo.utils;

/**
 * @Author Joker DJ
 * @Date 2021/8/7 20:58
 * @Version 1.0
 */

public class R {
    /**
     *标识返回状态
     */
    private Integer code;

    /**
     * 标识返回内容
     */
    private static Object data;
    /**
     * 标识返回消息
     */
    private String message;


    /**
     * 成功返回
     * @return
     */
    public static R ok(){
        return new R(0,data,"");
    }

//    /**
//     * 成功返回
//     * @param data
//     * @return
//     */
//    public static R ok(Object data,String message){
//        return new R(RHttpStatusEnum.SUCCESS.getCode(),data,message);
//    }

    /**
     * 失败返回
     * @param
     * @return
     */
    public static R error(String msg){
        return new R(1,null,msg);
    }
//    public static R error(Integer code,String message){
//        R r = new R();
//        r.code(code);
//        r.data(null);
//        r.message(message);
//        return r;
//    }



    public R() {

    }

    public R(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public R code(Integer code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public R data(Object data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public R message(String message) {
        this.message = message;
        return this;
    }
}


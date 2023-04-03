package com.myrestaurant.core.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Result类：泛型类，用于封装返回结果
 * @AllArgsConstructor: 全参构造器
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /**
     * HTTP响应结果的状态码
     */
    private int code;

    /**
     * HTTP响应结果的信息
     */
    private String msg;

    /**
     * HTTP响应结果的数据
     */
    private Object data;

    public static Result create(int code, String msg, Object data){
        return new Result(code, msg, data);
    }

    public static Result success(String msg, Object data){
        return create(200, msg, data);
    }

    public static Result success(String msg){
        return success(msg, null);
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(String msg, Object data){
        return create(500, msg, data);
    }

    public static Result error(String msg){
        return error(msg, null);
    }

    public static Result error(){
        return error(null);
    }

    public static Result flush(){
        return create(201, "", null);
    }

    public static Result wsMsg(String msg){
        return create(202, msg, null);
    }

}

package com.ebuy.tax.user.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
* @author dd
* @date 2018年9月4日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final long serialVersionUID = 2633283546876721434L;

    @ApiModelProperty(value="返回码")
    private Integer code=200;
    
    @ApiModelProperty(value="返回值描述")
    private String msg="操作成功";
    
    @ApiModelProperty(value="描述信息")
    private String description;
    
    @ApiModelProperty(value="返回数据")
    private T data;

    private HashMap<String,Object> exend;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public HashMap<String, Object> getExend() {
        return exend;
    }

    public void setExend(HashMap<String, Object> exend) {
        this.exend = exend;
    }

    public Result() {
        exend = new HashMap<>();
    }

    public static Result failure(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result ok(Map<String, Object> map) {
        Result result = new Result();
        result.exend.putAll(map);
        return result;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object value) {
        exend.put(key, value);
        return this;
    }
}

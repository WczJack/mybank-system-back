package com.neuedu.mobilebank.po;

public class ResponseBean<T> {
    //要分装的数据
    private T data;
    //数据状态码
    private Integer code;
    //数据状态信息提示
    private String msg;

    public ResponseBean() {
        super();
    }

    //数据正常封装
    public ResponseBean(T data) {
        super();
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }
    //数据异常状态封装
    public ResponseBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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
}

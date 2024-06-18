package com.neuedu.mobilebank.util;

public class MessageValidate {
    //生成验证码的静态方法
    public static String generateCode(){
        //定义一个有四个int型随机整数作为元素的数组
        int [] x={(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10)};
        //根据数组元素形成便是验证码的字符串
        StringBuffer sb = new StringBuffer(4);
        for(int a:x){
            sb.append(a);
        }
        return sb.toString();
    }
}

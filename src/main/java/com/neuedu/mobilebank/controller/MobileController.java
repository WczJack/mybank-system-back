package com.neuedu.mobilebank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neuedu.mobilebank.po.Mobile;
import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.service.MobileService;
import com.neuedu.mobilebank.service.RedisService;
import com.neuedu.mobilebank.util.MessageValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/mobile")
public class MobileController<String> {
    @Autowired
    private MobileService ms;

    @Autowired
    private RedisService rs;

    //登陆方法
    @PostMapping("/login")
    public ResponseBean<java.lang.String> login(Mobile mobile) throws JsonProcessingException {
        return ms.login(mobile);
    }

    //发送验证码的方法
    @GetMapping("/sendCode")
    public ResponseBean<String> sendCode(String telephone){
        ResponseBean<String> rb = null;
        //确认手机号是否已经注册过
        Long result = ms.checkMobileReged((java.lang.String) telephone);
        if(result > 0){
            rb = new ResponseBean<>(801,"手机号已经注册过");
        }else{
            //生成验证码
            String code = (String) MessageValidate.generateCode();
            //把验证码存入redis里(后面还要存token所以加个check)
            rs.save("check:"+telephone, (java.lang.String) code, 2, TimeUnit.MINUTES);
            rb = new ResponseBean<>(code);
        }
        return rb;
    }

    //验证前端输入的验证码是否正确
    @PostMapping("/checkCode")
    public ResponseBean<String> checkCode(String telephone, String code){
        String result = (String) rs.get("check:"+telephone, (java.lang.String) code);
        System.out.println("result:"+result);
        ResponseBean<String> rb = null;
        if(result == null){
            rb=new ResponseBean<>(804,"验证码过期");
        }else if (result.equals("success")) {
            rb=new ResponseBean<String>((String) "验证成功");
        }else{
            rb=new ResponseBean<>(805,"验证码输入错误");
        }
        return rb;
    }

    //手机注册功能
    @PostMapping("/regMobile")
    public ResponseBean<Integer> regMobile(Mobile mobile){

        return ms.regMobile(mobile);
    }
}

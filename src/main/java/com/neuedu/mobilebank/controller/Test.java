package com.neuedu.mobilebank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.mobilebank.po.Mobile;
import com.neuedu.mobilebank.util.JWTTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class Test {
    @GetMapping("/test")
    public String test() throws JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        Mobile mobile = new Mobile();
        mobile.setId(10);
        mobile.setPassword("123456");
        mobile.setTelephone("13488888888");
        String mobileJson = om.writeValueAsString(mobile);
        String token= JWTTool.createToken(mobileJson);
        System.out.println("token"+token);
        mobileJson=JWTTool.parseToken(token);
        System.out.println("mobileJson"+mobileJson);
        return "ok";
    }
}

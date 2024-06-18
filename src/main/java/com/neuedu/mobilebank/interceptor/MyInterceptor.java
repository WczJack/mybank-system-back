package com.neuedu.mobilebank.interceptor;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.mobilebank.mapper.RedisMapper;
import com.neuedu.mobilebank.po.Mobile;
import com.neuedu.mobilebank.util.JWTTool;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    @Qualifier("rmi")
    private RedisMapper rm;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("经过拦截器");
        String authToken = request.getHeader("Authorization");

        System.out.println("authToken="+authToken);

        //定义变量flag代表令牌对比结果
        boolean flag = true;
        if (authToken != null) {
            try {
                String token = authToken.substring("Bearer".length()+1).trim();
                String json= JWTTool.parseToken(token);
                ObjectMapper om = new ObjectMapper();
                Mobile result = om.readValue(json, Mobile.class);
                //从redis中获取存储过的令牌
                String storedToken = rm.get(result.getTelephone());
                System.out.println("storeToken="+storedToken);
                System.out.println("token="+token);
                if(storedToken == null || !(storedToken.equals(token)) ){
                    flag = false;
                }
            }catch (TokenExpiredException e){
                e.printStackTrace();
                flag = false;
            }
        }
        System.out.println("flag="+flag);
        System.out.println("authToken="+authToken);
        if(authToken == null || !flag){
            PrintWriter pw = response.getWriter();
            pw.print("invalid token");
            pw.close();
            return false;
        }



        return true;
    }
}

package com.neuedu.mobilebank.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.mobilebank.mapper.MobileMapper;
import com.neuedu.mobilebank.mapper.RedisMapper;
import com.neuedu.mobilebank.po.Mobile;
import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.service.MobileService;
import com.neuedu.mobilebank.util.JWTTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MobileServiceImpl implements MobileService {
    @Autowired
    private MobileMapper mm;

    @Autowired
    @Qualifier("rmi")
    private RedisMapper rm;

    @Override
    public ResponseBean<String> login(Mobile mobile) throws JsonProcessingException {
        ResponseBean<String> rb = null;
        QueryWrapper<Mobile> qw = new QueryWrapper<>();
        qw.eq("telephone", mobile.getTelephone());
        Mobile result =  mm.selectOne(qw);
        if(result == null){
            rb=new ResponseBean<>(801,"手机号错误，或者未注册");
        }else if(!(result.getPassword().equals(mobile.getPassword()))){
            rb=new ResponseBean<>(802,"密码错误");
        }else{
            //把已经验证过是正确的手机对象转换成json字符串
            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(result);
            //利用JWTTool把json转换成令牌
            String token = JWTTool.createToken(json);
            //把token存入redis中
            rm.save(result.getTelephone(), token, 60*60, TimeUnit.SECONDS);     //2*60
            //把令牌封装后传递给前端
            rb=new ResponseBean<>(token);
        }
        return rb;
    }

    @Override
    public Long checkMobileReged(String telephone) {
        QueryWrapper<Mobile> qw = new QueryWrapper<>();
        qw.eq("telephone", telephone);
        return mm.selectCount(qw);
    }


    @Override
    public ResponseBean<Integer> regMobile(Mobile mobile) {
        Integer result = mm.insert(mobile);
        ResponseBean<Integer> rb = new ResponseBean<>(result);
        return rb;
    }

}

package com.neuedu.mobilebank.service.serviceimpl;

import com.neuedu.mobilebank.mapper.RedisMapper;
import com.neuedu.mobilebank.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    @Qualifier("rmi")
    private RedisMapper rm;

    @Override
    public void save(String telephone, String value, long time, TimeUnit unit) {
        rm.save(telephone, value, time, unit);
    }


    @Override
    public String get(String telephone, String value) {

        String result = rm.get(telephone);
        if(result == null) {
            return null;
        }else if(value.equals(result)) {
            return "success";
        }else{
            return "failure";
        }
    }
}
